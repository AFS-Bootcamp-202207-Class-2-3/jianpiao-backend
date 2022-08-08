INSERT INTO "tb_action" ("id", "code", "name") VALUES ('1', 'INSERT', '新增');
INSERT INTO "tb_action" ("id", "code", "name") VALUES ('2', 'DELETE', '删除');
INSERT INTO "tb_action" ("id", "code", "name") VALUES ('3', 'UPDATE', '修改');
INSERT INTO "tb_action" ("id", "code", "name") VALUES ('4', 'SELECT', '查询');

INSERT INTO "tb_module" ("id", "code", "name") VALUES ('1', 'USER', '用户');

INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p1', 'USER:INSERT', 1, 1);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p2', 'USER:DELETE', 2, 1);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p3', 'USER:UPDATE', 3, 1);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p4', 'USER:SELECT', 4, 1);

INSERT INTO "tb_role" ("id", "role_name", "permission_ids") VALUES ('1', 'admin', '[p1,p2,p3,p4]');

INSERT INTO "tb_user" ("id", "email", "gender", "name", "nickname", "password", "photo", "tel", "username", "role_ids") VALUES ('1', '123@qq.com', '男', 'BaBy', 'baby', '123123', NULL, '11111111111', 'baby', '[1]');