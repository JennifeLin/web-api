TRUNCATE TABLE `reservations`;
TRUNCATE TABLE `boards`;
TRUNCATE TABLE `boards`;
TRUNCATE TABLE `restaurants`;
TRUNCATE TABLE `posts`;
TRUNCATE TABLE `sites`;

INSERT INTO `restaurants` (`id`, `address`, `description`, `image`, `name`, `created_at`, `updated_at`) VALUES (1, 'calle 1', 'description', 'https://upload.wikimedia.org/wikipedia/commons/e/ef/Restaurant_N%C3%A4sinneula.jpg', 'Restauran Nasinuella', NULL, NULL);
INSERT INTO `restaurants` (`id`, `address`, `description`, `image`, `name`, `created_at`, `updated_at`) VALUES (2, 'calle 3', 'comida japonesa', 'https://media.istockphoto.com/photos/group-of-friends-ordering-food-in-japanese-izakaya-picture-id1153738783?k=20&m=1153738783&s=612x612&w=0&h=f-DQ9rb-XhJcKFbUx2HRKmJINZCgeM8DQQPjRDVBodA=', 'Japanese Restaurant', NULL, NULL);

INSERT INTO `boards` (`id`, `capacity`, `number`, `restaurant_id`, `created_at`, `updated_at`) VALUES (1, 12, 4, 1, NULL, NULL);
INSERT INTO `boards` (`id`, `capacity`, `number`, `restaurant_id`, `created_at`, `updated_at`) VALUES (2, 5, 3, 1, NULL, NULL);
INSERT INTO `boards` (`id`, `capacity`, `number`, `restaurant_id`, `created_at`, `updated_at`) VALUES (3, 22, 10, 2, NULL, NULL);
INSERT INTO `boards` (`id`, `capacity`, `number`, `restaurant_id`, `created_at`, `updated_at`) VALUES (4, 6, 6, 2, NULL, NULL);

INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (1, '2022-02-10 00:45:39.000000', 'cancun', 12, '1', 1, NULL, NULL);
INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (2, '2022-01-11 00:46:27.000000', 'mexico', 11, '2', 1, NULL, NULL);
INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (3, '2022-02-09 00:46:35.000000', 'japon', 3, '1', 2, NULL, NULL);
INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (4, '2022-01-03 00:47:00.000000', 'corea', 6, '2', 2, NULL, NULL);
INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (5, '2022-02-11 22:12:01.775000', 'Japanese Restaurant_5', 123, 'turn_1_14:00', 2, NULL, NULL);
INSERT INTO `reservations` (`id`, `date`, `locator`, `person`, `turn`, `restaurant_id`, `created_at`, `updated_at`) VALUES (6, '2022-02-12 01:05:40.849000', 'Japanese Restaurant_6', 12, 'turn_2_20:00', 2, NULL, NULL);

INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (1, 'turn_1_10:00', 1, NULL, NULL);
INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (2, 'turn_2_13:00', 1, NULL, NULL);
INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (3, 'turn_3_6:00', 1, NULL, NULL);
INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (4, 'turn_4_9:00', 1, NULL, NULL);
INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (5, 'turn_1_14:00', 2, NULL, NULL);
INSERT INTO `turns` (`id`, `name`, `restaurant_id`, `created_at`, `updated_at`) VALUES (6, 'turn_2_20:00', 2, NULL, NULL);

INSERT INTO `sites` (`name`, `domain`) VALUES ('google', 'google.com');
INSERT INTO `posts` (`content`, `published_at`, `status`, `summary`, `title`, `site_id`, `is_published`, `slug_uri`) VALUES ('contenido completo', '2022-02-14', 'DRAFT', 'Pruebas sobre el desarrollo', 'Este es un ejemplo en la pagina', 1, b'1', 'ejemplo-de-pagina');
