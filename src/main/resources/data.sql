-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('本');
INSERT INTO categories(name) VALUES('DVD');
INSERT INTO categories(name) VALUES('ゲーム');
-- 商品テーブルデータ
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, 'Javaの基本', 2500, 3.7);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, 'MLB Fun', 980, 3.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(1, '料理BOOK!', 1200, 1.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'なつかしのアニメシリーズ', 2000, 3.4);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'The Racer', 1000, 2.5);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(2, 'Space Wars 3', 1800, 2.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'パズルゲーム', 780, 4.0);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'Invader Fighter', 3400, 4.3);
INSERT INTO items(category_id, name, price, avgpoint) VALUES(3, 'Play the BascketBall', 2200, 3.4);


-- 商品テーブルデータ
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, '分かりやすかった', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, '見やすくまとまっている', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(1, '楽しく勉強できた', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(2, '分かりやすかった', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, '分かりにくかった', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, '失敗した', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, '細かいところが分からない', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(3, '読みずらい', 0);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, '懐かしい気分になった', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, 'しらないアニメが多かった', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, '普通に面白かった', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, '面白かった', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(4, '懐かしい', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(5, '普通', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(5, '平凡だと感じた', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(6, '前作が面白過ぎたかも知れない', 1);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(6, '普通に面白い', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, '思っていたよりも難しい', 3);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, '達成感がある', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(7, '面白かった', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, '面白い', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, '楽しい', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(8, '良かった', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, '面白い', 5);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, 'キャラがいい', 4);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, '操作が難しい', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, '敵が強すぎる', 2);
INSERT INTO reviews(item_id, review, reviewpoint) VALUES(9, '面白い', 4);