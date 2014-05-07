# TankWar
### Release Note :

1. Version 0.1
	1. Add TankClient.
	2. Add a window, and a window closing event.
	3. Set this frame is not resizable by the user.
	4. Use common variables as static final.
2. Version 0.2
	1. Add a red tank.
	2. Set background is BLACK.
3. Version 0.3
	1. Through the thread and repaint, make the tank move.
	2. Set tank's coordinate position to variable values.
4. Version 0.4
	1. Use double buffer to eliminate the flicker phenomenon.
	2. Add a update method.
	3. Create a Image on the back of the window in the update method.
5. Version 0.5
	1. Add KeyAdapter to control the tank.
6. Version 0.6
	1. Add a Tank Class.
	2. Add draw and KeyPressed method.
	3. Use Tank's draw and KeyPressed method in the TankClient.
7. Version 0.7
	1. Using eight direction control tank.
	2. Add locateDirection, keyReleased and move method.
8. Version 0.8
	1. Add a Missile class.
	2. Add draw and move method in the Missile class.
9. Versuib 0.9
	1. Add a fire method in Tank class.
	2. TankClient get a Missile from fire method. But now can only make one missile.
10. Version 1.0
	1. Draw a WHITE gun barrel, add ptDir.
11. Version 1.1
	1. Use List store missiles. Now tank can fire multiple missile.
12. Version 1.2
	1. Not allow the tank is out of the window bounds.
	2. When the missile if out of the window bounds, remove it.
13. Version 1.3
	1. Add a boolean good in the Tank class.
	2. Add a enemytank.
14. Version 1.4
	1. Add a hitTank method in the Missile class.
	2. Use the Rectangle.intersects judging whether the missile hit the tank.
15. Version 1.5
	1. Add a Explode class.
16. Version 1.6	
	1. Use List store enemytank, can make multiple tank.
	2. Add a hitTanks method in Missile class.
17. Version 1.7
	1. Use Random make the enemytank can move and fire. 
18. Version 1.8
	1. Add a Wall class.
	2. Add the hitWall method make the tank and missile can't through the wall.
19. Version 1.9
	1. Add hitTanks and hitTank method make the different tank can't collide.
20. Version 2.0
	1. Add superfire ans fire method in the Tank class.
	2. Press A, my tank can make superfire.
21. Version 2.1
	1. Add my tank's life, my tank has 100 value of life.
22. Version 2.2
	1. Add a BloodBar class in Tank class, it can show my tank's life.
23. Version 2.3
	1. Add a Blood class.
	2. Add a eat method in the Tank class. It can add my tank's life.
24. Version 2.4
	1. Modify the picture version.
25. Version 2.5
	1. Add PropertyMgr class, it's a config doc.
	2. Use Singleton pattern for config doc.
