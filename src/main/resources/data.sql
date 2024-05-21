-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('本');
INSERT INTO categories(name) VALUES('DVD');
INSERT INTO categories(name) VALUES('ゲーム');
-- 商品テーブルデータ
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, 'Javaの基本', 2500, 3.7);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, 'MLB Fun', 980, 0.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, '料理BOOK!', 1200, 1.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'なつかしのアニメシリーズ', 2000, 3.4);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'The Racer', 1000, 2.5);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'Space Wars 3', 1800, 2.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'パズルゲーム', 780, 4.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'Invader Fighter', 3400, 4.3);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'Play the BascketBall', 2200, 3.4);


-- 商品テーブルデータ
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, 'xxx', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, 'xxx', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, 'xxx', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, 'xxx', 0);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'xxx', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'xxx', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(5, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(5, 'xxx', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(6, 'xxx', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(6, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, 'xxx', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, 'xxx', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, 'xxx', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'xxx', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'xxx', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'xxx', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'xxx', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'xxx', 4);