It's an springboot app which is api for unity games. 
You can use it for creating ranking in your game.

# <b>USAGE</b>
    
<ol>
<li>**getting rank**
    <br>
    
    /rank/{gameTitle}
    _GET METHOD_
    
<li>**posting rank**
    <br>
    
    /rank/{gametitle}/add -> posting new score
    !You have to send json data
    _POST METHOD_

<li>**Login/signup**

    /login -> login form here (working)
    /signup -> signup form here (working)

</ol>

# <b>DATABASE STRUCTURE</b>
        SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
``START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `hibernate_sequence` (
`next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `rank` (
`id` int(11) NOT NULL,
`username` varchar(30) NOT NULL,
`score` int(11) NOT NULL,
`gametitle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `users` (
`userid` int(11) NOT NULL,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `rank`
ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
ADD PRIMARY KEY (`userid`),
ADD UNIQUE KEY `username` (`username`);


ALTER TABLE `rank`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

ALTER TABLE `users`
MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;
COMMIT;``
