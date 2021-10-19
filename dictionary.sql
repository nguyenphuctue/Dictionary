CREATE DATABASE dictionary;

CREATE TABLE word
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    wordTarget  VARCHAR(255) UNIQUE,
    wordExplain NVARCHAR(255),
    pronounce   NVARCHAR(20),
    wordType    NVARCHAR(20)
);

INSERT INTO word(wordTarget, wordExplain, pronounce, wordType)
VALUES ('extreme', 'vô cùng', '[ikˈstriːm]', 'Tính từ'),
       ('become', 'trở nên', '[bi’kʌm]', 'Động từ'),
       ('choose', 'lựa chọn', '[t∫u:z]', 'Động từ'),
       ('begin', 'bắt đầu', '[bi’gin]', 'Động từ'),
       ('catch', 'bắt, chụp', '[kæt∫]', 'Động từ'),
       ('dream', 'mơ thấy', '[dri:m]', 'Động từ'),
       ('go', 'đi', '[gou]', 'Động từ'),
       ('leave', 'rời đi', '[li:v]', 'Động từ'),
       ('overcome', 'khắc phục', '[,ouvə’kʌm]', 'Động từ'),
       ('Apple  ', 'táo', '/’æpl/', 'Danh từ'),
       ('Avocado ', 'trái bơ', '/¸ævə´ka:dou/', 'Danh từ'),
       ('Coconut', 'dừa', '/’koukənʌt/', 'Danh từ'),
       ('Mango ', 'xoài', '/´mæηgou/', 'Danh từ'),
       ('government', 'chinh phu', '/ˈgʌvnmənt /', 'Danh từ'),
       ('Mandarin ', '/’mændərin/', '/’mændərin/', 'Danh từ');

