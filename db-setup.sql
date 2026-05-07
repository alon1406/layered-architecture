CREATE USER softdev WITH PASSWORD 'Restaurant2026';
CREATE DATABASE restaurantdb OWNER softdev;
\c restaurantdb
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO softdev;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO softdev;
CREATE TABLE restaurant_order (id BIGSERIAL PRIMARY KEY, meal_name VARCHAR(255), status VARCHAR(50));
INSERT INTO restaurant_order (meal_name, status) VALUES ('Double McRoyal Meal', 'PREPARING'), ('9 McNuggets', 'READY'), ('Big Mac', 'RECEIVED');
