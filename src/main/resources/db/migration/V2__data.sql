insert into roles(id, name) values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

insert into users(id, email, password, username) values
(0, 'alekcandr206@gmail.com', '$2a$10$ZXBxX320/zoJts9PKqYgQuBjphWLIL6MVvVhctVWFBfP49kkXJYE.', 'samedov');

insert into user_roles(user_id, role_id) values
(0, 1);

insert into event(id, date, description, title, creator_id) values
(0, null, 'simple', 'simple', 0);

insert into sportsman(id, age, first_name, last_name, year_of_birth) values
(0, 20, 'Alex', 'Ivanov', 2000);