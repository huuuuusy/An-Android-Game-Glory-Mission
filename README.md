# An-Android-Game-Glory-Mission

Hi everyone！

This blog is for my App development project in HKU, and I'd like to orgainze it and share the project to you. For more information about this App, here is the [demo](https://youtu.be/wLwp-sWVtWI).

** This is a group project and my other two teammates are Meng Liuchen and Lu Yuhan, thanks a lot for there hardwork in this project!**


# 1 Basic Information

I use Android Studio 2.3.3 to develop this APP and compile this in Nexus_S with API Level 23:5554.

This APP contains 8 pages: The main page, the sign up page, the login page, the function choose page, the actor choose page, the result page, the edit user page and the game page. Now I will introduce the functions in the following steps.

In the game, a player can create his own account in the game and log in to play
games, winning the game by leading your own character to the destination. All the
paths the character passes by will be marked and if the character step on the marked
area, player loses the game immediately. When the character gets to the assigned
destination, player will enter next level automatically. All the levels are simple but
different. There is also background music for different pages to add more
entertainment. Players won’t find it boring because there are some unpredictable ways
to win the game. In a word, it is a perfect game for busy people to kill time.

## 1.1 Start Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516360368/Screenshot_1516360362_vgmq5a.png)

The start page includes the title with two buttons. The **SIGN UP** button links the sign up page, while the **LOG IN** links the login page. 

## 1.2 Sign Up Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516360563/Screenshot_1516360544_hmnvbp.png)

In this page, the new player needs to input an unique username and a personal password. For security reason, the  password needs at least 6 characters, or the App will show the warning information.

For example, I can use user1 as my username and assign 111111 as the password.

## 1.3 Login Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516360930/Screenshot_1516360544_thncee.png)

The login page looks like the sign up page. In this page, the user needs input the username and password to verify information. After that, by clicking the **Save** button, the interface will jump to the function choose page. 

## 1.4 FUnction Choose Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516361188/Screenshot_1516361124_ivg76w.png)

In this page, the user can choose the function to enjoy. For **Start** button, it will link to the actor choose page. For **Grade** button, the user can show his or her grades and the ranking list for all the players. For **Edit** button, the player can change the password.

## 1.5 Actor Choose Page 

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516361444/Screenshot_1516361433_cc4hyb.png)

In this page, the player can select the actor according to the interests. The game provides two actors, the brave boy and the brave girl. After selecting the character, you can enjoy the game with your favorite actor.

## 1.6 Game Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516362013/Screenshot_1516361939_ynklfs.png)

The speciftic rule for this game will be introduced in Part 2. As the image above, the game provides different scenes for players. In each scene, the game sets some barriers. In order to pass each level, player should manipulate the character to skirt barriers by using the direction buttons below. 

## 1.7 Grade Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516362345/Screenshot_1516362329_djhhgz.png)

The grade page provides the ranking list for all the users. You can compare your grades with others. What's more, the game will save your prograss automatically, which means that you can start the game according to the record.

## 1.8 Edit Page

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516362542/Screenshot_1516362501_khmv3r.png)

In this page, the user can edit personal information such as the username and the password. After that, the user can use new information to login the game while no change in game progress. 

## 2 Game Rules

The best way to understand the gameplay is by watching the demo.

Glory Mission provides several levels for players. To pass the game level, users need to find the correct way in each map. The barriers provide distractions while one block can pass only once adds the difficulty.

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516362894/Screenshot_1516362879_owkcnm.png)

The blocks that character has passed will be colored as brown. The hole in the map will link to next layer of the same level.

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516363030/Screenshot_1516363023_p0blhc.png)

The image above shows the second layer of level 1. The exit(which will link to next page) looks like a gate. Arriving the exit in neither layer 1 or layer 2 will lead to next level.

![](http://res.cloudinary.com/dyy3xzfqh/image/upload/v1516363191/Screenshot_1516363172_cnlidi.png)

This image shows the setting of level 2, which has the same rule of level 1. Arriving to the exit in last level will win the game.

However, if the character passes a block twice, the game will finish and he or she can start in the level that failed last time.

