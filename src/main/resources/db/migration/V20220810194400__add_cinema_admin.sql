INSERT INTO "tb_module" ("id", "code", "name") VALUES ('2', 'CINEMA', '影院');

INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p5', 'CINEMA:INSERT', 1, 2);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p6', 'CINEMA:DELETE', 2, 2);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p7', 'CINEMA:UPDATE', 3, 2);
INSERT INTO "tb_permission" ("id", "code", "action_id", "module_id") VALUES ('p8', 'CINEMA:SELECT', 4, 2);

INSERT INTO "tb_role" ("id", "role_name", "permission_ids") VALUES ('2', 'cinema-admin', '[p5,p6,p7,p8]');

INSERT INTO "tb_role" ("id", "role_name", "permission_ids") VALUES ('3', 'customer', '[]');

INSERT INTO "tb_user" ("id", "email", "gender", "name", "nickname", "password", "photo", "tel", "username", "role_ids")
VALUES ('cadmin1', '123@qq.com', '男', 'BaBy', 'baby', '123123', NULL, '11111111111', 'cadmin', '[2]');
