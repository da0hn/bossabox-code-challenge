CREATE (notion:Tool {
  title:       'Notion',
  link:        'https://notion.so',
  description: 'All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.'
})

// tags for notion
CREATE (organization:Tag {name: 'organization'})
CREATE (planning:Tag {name: 'planning'})
CREATE (collaboration:Tag {name: 'collaboration'})
CREATE (writing:Tag {name: 'writing'})
CREATE (calendar:Tag {name: 'calendar'})

// create relations
CREATE (organization)<-[:TAGGED_BY]-(notion)
CREATE (planning)<-[:TAGGED_BY]-(notion)
CREATE (collaboration)<-[:TAGGED_BY]-(notion)
CREATE (writing)<-[:TAGGED_BY]-(notion)
CREATE (calendar)<-[:TAGGED_BY]-(notion)

// -------------------------------------------------------------------------------

CREATE (jsonserver:Tool {
  title:       'json-server',
  link:        'https://github.com/typicode/json-server',
  description: 'Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges.'
})
// tags for json-server
CREATE (api:Tag {name: 'api'})
CREATE (json:Tag {name: 'json'})
CREATE (schema:Tag {name: 'schema'})
CREATE (github:Tag {name: 'github'})
CREATE (rest:Tag {name: 'rest'})
CREATE (node:Tag {name: 'node'})

// create relations
CREATE (api)<-[:TAGGED_BY]-(jsonserver)
CREATE (json)<-[:TAGGED_BY]-(jsonserver)
CREATE (schema)<-[:TAGGED_BY]-(jsonserver)
CREATE (github)<-[:TAGGED_BY]-(jsonserver)
CREATE (rest)<-[:TAGGED_BY]-(jsonserver)
CREATE (node)<-[:TAGGED_BY]-(jsonserver)

// -------------------------------------------------------------------------------

CREATE (fastify:Tool {
  title:       'fastify',
  link:        'https://www.fastify.io/',
  description: 'Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.'
})

// tags for fastify
CREATE (web:Tag {name: 'web'})
CREATE (framework:Tag {name: 'framework'})
CREATE (http2:Tag {name: 'http2'})
CREATE (https:Tag {name: 'https'})
CREATE (localhost:Tag {name: 'localhost'})

// create relations
CREATE (web)<-[:TAGGED_BY]-(fastify)
CREATE (framework)<-[:TAGGED_BY]-(fastify)
CREATE (http2)<-[:TAGGED_BY]-(fastify)
CREATE (https)<-[:TAGGED_BY]-(fastify)
CREATE (localhost)<-[:TAGGED_BY]-(fastify)
CREATE (node)<-[:TAGGED_BY]-(fastify)

// -------------------------------------------------------------------------------
// default password: 12345678

CREATE (yuriduli:User {
  username: 'yuriduli',
  password: '$2a$10$O2kKb.ooh.uwzTG7HILU5.f2LnokqdjaOSDeXaZGCrV83X3EHrWiq',
  email:    'yuriduli13@gmail.com'
})

CREATE (da0hn:User {
  username: 'da0hn',
  password: '$2a$10$O2kKb.ooh.uwzTG7HILU5.f2LnokqdjaOSDeXaZGCrV83X3EHrWiq',
  email:    'da0hn@gmail.com'
})

CREATE (admin:Role {
  name: 'ADMIN'
})

CREATE (user:Role {
  name: 'USER'
})

CREATE (yuriduli)-[:HAS]->(user)

CREATE (da0hn)-[:HAS]->(admin)
CREATE (da0hn)-[:HAS]->(user)
