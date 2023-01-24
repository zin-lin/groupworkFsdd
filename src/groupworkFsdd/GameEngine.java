package groupworkFsdd;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import groupworkFsdd.Values.Values;
import groupworkFsdd.aliens.Alien;
import groupworkFsdd.items.*;
import groupworkFsdd.planets.Haliv;
import groupworkFsdd.planets.Maxgog;
import groupworkFsdd.planets.Planet;
import groupworkFsdd.planets.Podorth;
import groupworkFsdd.players.*;

/**
 * 
 * @author Group 7 FSDD
 * game class
 */

public class GameEngine {

	/**
	 *
	 * @param o, defines what to be printed
	 * @reference Tatooine, Star Wars: planet Tatooine
	 */
	public static void print (Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {


		Player player1 = new Player("player1xxpty_mingog_game", "mingog", 0, 250);
		Player player2 = new Player("player2xxpty_mingog_game", "evu", 500, 250);
		Planet planet = new Planet();

		ArrayList<Player> players = new ArrayList<>();
		ArrayList<Resource> resources = new ArrayList<>();
		players.add(player1);
		players.add(player2);

		/**
		 * @objective
		 * Planet colonisation game
		 * Design a strategy game in which different alien
		 * races are fighting to colonise a planet. Each player starts with a small
		 * number of units of an alien race of their choice. By collecting resources,
		 * they can create further units. Resources are scattered around the planet, and
		 * can be of different types. Different types of unit require different
		 * resources to build. Each type of unit has strength, range and accuracy values
		 * for its weapons, and has a shield. When the unit is hit its shield value
		 * decreases. The game is over when one player destroys all of the units of
		 * another.
		 */

		//Game Instansiations 


		System.out.println("Choose your battleground (type 1, 2, 3) :\n 1) Maxgog, Tatooine like sand planet \n 2) Podorth, the mineral rich planet \n 3) Haliv, the valcanic planet");

		//<Section> Planet Selection

		Scanner readPlanet = new Scanner(System.in);
		int planetIndex  = readPlanet.nextInt();

		switch (planetIndex) {
			case 1:
				planet = new Maxgog();
				break;
			case 2:
				planet = new Podorth();
				break;
			case 3:
				planet = new Haliv();
				break;
				
			default:
				planet = new Maxgog();
				break;
		}

		//</Section>

		ArrayList<String> names = new ArrayList<>();
		ArrayList<String> races = new ArrayList<>();
		for (int i = 0; i < 2; i++) {

			Scanner reader = new Scanner(System.in);
			Scanner reader1 = new Scanner(System.in);

			print("Input Player name : ");
			String name = reader.nextLine();
			print("Input Player race (type 1, 2, 3) :\n1) Mingog \n2) Evu \n3) Trul \n4) Sirith \n5) Lunzar ");
			String race = reader.nextLine();
			race = Values.nameReturner(race);

			if (!names.contains(name)) {
				players.get(i).setName(name);
				names.add(name);
			} else {
				players.get(i).setName(name + "1");
				names.add(name + "1");
			}

			if (!races.contains(race)) {
				players.get(i).setRace(race);
				races.add(race);
			} else {
				Scanner readerAgain = new Scanner(System.in);
				String former = races.get(0);
				print("Opps!, Same Races will not fight their own people\n Input Player race (type 1, 2, 3) :\n1) Mingog \n2) Evu \n3) Trul \n4) Sirith \n5) Lunzar ");
				String raceAgain = readerAgain.next();
				raceAgain = Values.nameReturner(raceAgain);
				raceAgain = raceAgain.equals(former) ? "evu" :  raceAgain;
				players.get(i).setRace(raceAgain);

				races.add(raceAgain);
			}

		}


		while (true) {

			if (players.get(0).getUnits().size() == 0){
				print(player2.getName() + " wins");
				break;
			}

			else if (players.get(1).getUnits().size() == 0) {
				print(player1.getName() + " wins");
				break;
			}

			for (int i = 0; i < planet.getNumBronze(); i++) {
				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Bronze(ranX, ranY));


			}
			for (int i = 0; i < planet.getNumGold(); i++) {
				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Gold(ranX, ranY));


			}
			for (int i = 0; i < planet.getNumSilver(); i++) {

				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Silver(ranX, ranY));

			}
			for (int i = 0; i < planet.getNumCurrency(); i++) {

				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Currency(ranX, ranY));



			}
			for (int i = 0; i < planet.getNumShield(); i++) {

				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Shield(ranX, ranY));



			}
			for (int i = 0; i < planet.getNumHealth(); i++) {

				Random random = new Random();
				int ranX = random.nextInt( 500);
				int ranY = random.nextInt( 500);

				resources.add(new Health(ranX, ranY));



			}

			for (int pIndex = 0; pIndex < players.size(); pIndex ++)
			{

				int oIndex = (pIndex == 0) ? 1 : 0;
				/**
				 * Killing off the dead characters
				 */
				ArrayList<Integer> deadIndexes1 = new ArrayList<>();
				ArrayList<Integer> deadIndexes2 = new ArrayList<>();
				for (int i = 0; i < players.get(pIndex).getUnits().size(); i++) {
					Alien alien = players.get(pIndex).getUnits().get(i);
					if (alien.getLife() <= 0) {
						deadIndexes1.add(i);
					}
				}

				for (int index : deadIndexes1) {
					players.get(pIndex).getUnits().remove(index);
				}

				for (int i = 0; i < players.get(oIndex).getUnits().size(); i++) {
					Alien alien = players.get(oIndex).getUnits().get(i);
					if (alien.getLife() <= 0) {
						deadIndexes2.add(i);
					}
				}

				for (int index : deadIndexes2) {
					players.get(oIndex).getUnits().remove(index);
				}

				if (players.get(0).getUnits().size() == 0){

					break;
				}

				else if (players.get(1).getUnits().size() == 0) {

					break;
				}

												
				//<End of kill>

				Scanner scanner = new Scanner(System.in);

				print("Hello " + players.get(pIndex).getName() + " \n Now you can click \n1 to perform special attack\n" + "2 to to purchase new Units\n3 to quit the game\n4 to upgrade units\n5 to move on");

				String option = scanner.nextLine();
				switch (option) {
					case "1":
						players.get(pIndex).specialAttack(players.get(oIndex).getUnits()); //Player 2's or The Current Player's Unit will be affected
						break;

					case "2":
						Scanner reader = new Scanner(System.in);
						print("How many do you like to purchase. Your resource is " + (players.get(pIndex).getResources()));
						int num = reader.nextInt(); int counter = 0;
						for (int i = 0; i < num; i++) {

							if (players.get(pIndex).getResources() >= Values.valueReturner(players.get(pIndex).getRace())) {
								int xx = pIndex == 0? 0: 500 ;
								players.get(pIndex).addUnit(xx, 250);
								counter ++;
							} else {

								break;
							}
						}

						print(counter + " units purchased and added on the grid, you still have " + (players.get(pIndex).getResources()));

						break;

					case "3":
						print(players.get(pIndex).toString() + " quits");
						players.get(pIndex).getUnits().removeAll(players.get(pIndex).getUnits());
						break;

					case "4":
						print("all players upgrade");
						players.get(pIndex).upgrade();
						break;

					case "5":
						break;

					default:
						break;

				}//switch option

				int index = 1;
				for (Alien alien : players.get(pIndex).getUnits()) {
					print("You are in control of " + players.get(pIndex).getRace() + " " + index + " Unit is at " + alien.toString());
					ArrayList<Integer> enemiesIndexs = alien.findFoes(players.get(oIndex).getUnits());
					ArrayList<Integer> resourceIndexs = alien.findResources(resources);



					print( "\nYour options:"
							+ "\nmove (press 'm')"
							+ (enemiesIndexs.size() > 0 ? "\nattack (press 'a')" : "")
							+ (resourceIndexs.size() > 0 ? "\ncollect resource (press 'c')" : "")
					);

					Scanner scannerCommand = new Scanner(System.in);
					String command = scannerCommand.nextLine();

					switch (command) {
						case "m":
							//<Section> Move
							print("Enter x direction, hit enter, and enter y direction:");
							Scanner moverX = new Scanner(System.in);
							Scanner moverY = new Scanner(System.in);
							int x = moverX.nextInt();
							int y = moverY.nextInt();
							alien.move(x, y);

							break;

						case "a":
							//<Section> Attack
							if (enemiesIndexs.size() > 0) {
								print("Options to attack- ");
								for (int ind : enemiesIndexs) {
									print(players.get(oIndex).getRace() + " " + ind);
								}
							

							Scanner attack = new Scanner(System.in);
							int attackInd = attack.nextInt();

							if (enemiesIndexs.contains(attackInd)) {
							alien.attack(players.get(oIndex).getUnits().get(attackInd), planet.getTemperatureEffect());
							} else {
								print("You tried to attack an enemy out of your range, unit is skipped, Penalisedd!!!");
							}
							//Attack Specific Index
							}

							break;

						case "c":
							//<Section> Collect
							
							print("Press the index of the item you wanna collect (e.g. press 68 for gold 68)");
							if (resourceIndexs.size() > 0) {
								print("Options to collect- ");
								for (int ind : resourceIndexs) {
									print(resources.get(ind).getType() + " " + ind);
								}
							Scanner res = new Scanner(System.in);
							int indd = res.nextInt();
							if (resourceIndexs.contains( indd) ){
							alien.collect(resources.get(indd));
							} else {
								print("You try to collect the item out of your range, your unit is skipped. Penalised!!!");
							}
							}
							//</Section>
							break;

						default:
							break;
					}//switch command

					index++;
				}//each alien (//forEach)

			}//for Loop
			}//while Loop


	}//main

}//class
