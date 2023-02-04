CREATE (yuriduli:User {
  username: 'yuriduli',
  password: 'yUr1DuL1',
  email:    'yuriduli13@gmail.com'
})

CREATE (da0hn:User {
  username: 'da0hn',
  password: '123456',
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


