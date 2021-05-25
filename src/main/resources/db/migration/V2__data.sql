insert into roles(id, name) values
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_MODERATOR');

insert into users(id, email, password, username) values
(0, 'admin@localhost.com', '$2a$10$s84Mk0jcCBzHuR0eOLa3f.KfPYmK3aWjjG.PaCUrLFR8A2oqhJqhO', 'admin'),
(1, 'user@localhost.com', '$2a$10$FaSIjDdaCVqZLaMCBtFTeO71F/DjugKN6HyzibGyTirBKsmHi21RK', 'user'),
(2, 'moderator@localhost.com', '$2a$10$JyL2Q1BNqWrGRrLm4lQLcuB2BJv996o9mHeb1s5fDYl2RxruszsMi', 'moderator');

insert into user_roles(user_id, role_id) values
(0, 1),
(1, 2),
(2, 3);

insert into event(id, date, description, title, creator_id) values
(0, '2021-05-25', 'simple', 'simple', 0);

insert into sportsman(id, age, first_name, last_name, year_of_birth) values
(0, 20, 'Alex', 'Ivanov', 2000);

insert into participation(id, name, result, sportsman_id) values
(1, 'пятиборье', 300, 0);

insert into participation_application(id, university, creator_id, event_id) values
(0, 'mirea', 2, 0);