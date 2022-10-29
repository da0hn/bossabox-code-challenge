#!/bin/bash

# https://github.com/marcellodesales/neo4j-with-cypher-seed-docker

log_info() {
  printf '%s %s\n' "$(date -u +"%Y-%m-%d %H:%M:%S:%3N%z") INFO  Wrapper: $1"
  return
}

set -m

/docker-entrypoint.sh neo4j &

log_info "Waiting until neo4j stats at :7474 ..."
wget --quiet --tries=10 --waitretry=10 -O /dev/null http://localhost:7474

HAS_DATA=$(echo $(cypher-shell --format plain "MATCH (n) RETURN count(n) as COUNT") | sed 's/[^0-9]*//g')

log_info "Already has data $(echo ${HAS_DATA}) nodes"

if [[ $HAS_DATA -eq 0 && -d "/cyphers" ]]; then
  log_info "Deleting all relations"
  cypher-shell --format plain "MATCH (n) DETACH DELETE n"

  log_info "Loading cyphers from '/cyphers'"
  for cipherFile in /cyphers/*.cql; do
    log_info "Running cypher ${cipherFile}"
    contents=$(cat "${cipherFile}")
    cypher-shell -a bolt://localhost:7687 "${contents}"
  done
  log_info "Finished loading all cyphers from '/cyphers'"

  TOTAL_CHANGES=$(cypher-shell --format plain "MATCH (n) RETURN count(n) AS count")
  log_info "Changes $(echo ${TOTAL_CHANGES} | sed -e 's/[\r\n]//g')"
else
  log_info "Seeding not necessary, skipping..."
fi

fg %1
