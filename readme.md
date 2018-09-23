POST : /api/users/5/contacts   Request Body

GET : /api/users/5/contacts

PUT : /api/users/5/contacts/1   Request Body

DELETE : /api/users/5(id)/contacts/1(id)


GET : /api/users/contacts ? username=sj&contact=y
       /api/user/{name}/contacts/{contactName}
     /api/users/5(id)/contacts/3(id) ---推荐
     
     
     1. 给User(id=5)创建一个Contact
     2. 查询User(id=5)的Contact
     3. 更新User(id=5)的某个Contact
     4. 删除User(id=5)的某个Contact
     5. 查询User(name=sjyuan)的Contact(name=yang kaiguang)
     