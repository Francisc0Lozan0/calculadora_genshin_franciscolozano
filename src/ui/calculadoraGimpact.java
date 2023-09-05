package ui;

import java.util.*;
//cambio 1

public class calculadoraGimpact {

    public static Scanner txt = new Scanner(System.in);
    public static boolean cut; // creating varibales type boolean

    public static int options_menu, character, count2, count_reaccions; // creating variables that contain int values

    public static List<Double> damages = new ArrayList<>(); // the list of the damages

    /*
     * aleatory_multiresistance method
     * description: Calcule a number between 0.5 and 2
     * precondition: None
     * Postcondition: Does not affect global variables.
     * 
     * @param None
     * 
     * @return <multiresistance> value type double that represents the multiplier
     * resistance
     */
    public static double aleatory_multiresistance() {

        Random random = new Random();
        double multiresistance = 0.5 + (random.nextDouble() * (2 - 0.5));

        return multiresistance;

    }

    public static double character_attack, character_level, critical_damage_probability,
            critical_damage_percentage, elemental_mastery, reaction_multiplier, multiplier_eleccion, var_basedamage,
            var_transformativedamage, bonoME, multiampli, var_amplificativedamage, var_additivedamage, total_damage,
            damage, highestdamage; // generating the varibles with double values

    public static String choice; // varible for the election in the differents reactions

    // ----------------------------------------------------------------

    // ----------------------------------------------------------------
    public static void charact_attack() {
        while (cut) {
            System.out.println("Enter the character attack");
            if (txt.hasNextDouble()) {
                character_attack = txt.nextDouble();

                if (character_attack < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                } else {
                    cut = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                txt.next();
                continue;
            }
        }
    }

    public static void probability_critical() {
        while (cut) {
            System.out.println("Enter the probability of critical damage");
            if (txt.hasNextDouble()) {
                critical_damage_probability = txt.nextDouble();

                if (critical_damage_probability < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                } else {
                    cut = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                txt.next();
                continue;
            }
        }
    }

    public static void critical_percentage() {
        while (cut) {
            System.out.println("Enter the critical damage percentage");
            if (txt.hasNextDouble()) {
                critical_damage_percentage = txt.nextDouble();

                if (critical_damage_percentage < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                } else {
                    cut = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                txt.next();
            }
        }
    }

    public static void elem_mastery() {
        while (cut == true) { // loop for obligate the user to put a correct value
            System.out.println("Enter the elemental mastery");
            if (txt.hasNextDouble()) { // "txt.hasNextDouble" detect if the value is a double, and if is true realize
                                       // the operation that have behind

                elemental_mastery = txt.nextDouble();

                if (elemental_mastery < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                } else if (elemental_mastery > 0) {
                    cut = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                txt.next();
                continue;
            }
        }

    }

    public static void charac_level() {
        while (cut == true) {
            System.out.println("Enter the character level");
            if (txt.hasNextDouble()) {
                character_level = txt.nextDouble();

                if (character_level < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                } else if (character_level > 0) {
                    cut = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                txt.next();
                continue;
            }
        }
    }

    public static void transformative_multiplier() {
        while (cut == true) {

            System.out.println("What type of transformation multiplier do you want to use?\n" +
                    "1. Burn\n" +
                    "2. Superconductor\n" +
                    "3. Whirlwind\n" +
                    "4. Electrocharged\n" +
                    "5. Crystallization\n" +
                    "6. Overloaded\n" +
                    "7. Overblossom\n" +
                    "8. Overblossom and Superburn");

            txt.nextLine();
            String choice;
            choice = txt.nextLine();

            switch (choice) {
                case "1":
                    multiplier_eleccion = 0.25;
                    cut = false;
                    break;
                case "2":
                    multiplier_eleccion = 0.50;
                    cut = false;
                    break;
                case "3":
                    multiplier_eleccion = 0.6;
                    cut = false;
                    break;
                case "4":
                    multiplier_eleccion = 1.2;
                    cut = false;
                    break;
                case "5":
                    multiplier_eleccion = 1.5;
                    cut = false;
                    break;
                case "6":
                    multiplier_eleccion = 2.0;
                    cut = false;
                    break;
                case "7":
                    multiplier_eleccion = 2.0;
                    cut = false;
                    break;
                case "8":
                    multiplier_eleccion = 3.0;
                    cut = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            break;
        }

    }

    public static void amplificative_multiplier() {

        while (cut) {

            System.out
                    .println(
                            "What type of amplificative multiplier do you want to use? \n 1. Vaporization \n 2. Melting");

            choice = txt.nextLine();
            switch (choice) {
                case "1":
                    //
                    reaction_multiplier = 1.5;
                    cut = false;
                    break;
                case "2":
                    //
                    reaction_multiplier = 2.0;
                    cut = false;
                    break;
                default:
                    cut = true;

            }
        }

    }

    public static void additive_multiplier() {
        while (cut) {

            System.out
                    .println(
                            "What type of additive multiplier do you want to use? \n 1. Intensification \n 2. Propagation");

            choice = txt.nextLine();
            switch (choice) {
                case "1":
                    //
                    multiplier_eleccion = 1.15;
                    cut = false;
                    break;
                case "2":
                    //
                    multiplier_eleccion = 1.25;
                    cut = false;
                    break;
                default:
                    cut = true;

            }

        }
    }

    // ----------------------------------------------------------------

    // ----------------------------------------------------------------

    /*
     * base_damage_method {
     * Description: The method is responsible for calculating base damage through
     * character attack, critical damage probability, and entered percentage of
     * critical damage.
     * Precondition: The method receives 3 variables and returns a result without
     * affecting global variables.
     * Postcondition: Does not affect global variables.
     * 
     * @return base_damage A float-type variable, the result of the operation using
     * the input data character_attack, critical_damage_probability, and
     * critical_damage_percentage.
     */
    public static double base_damage() {
        cut = true;
        charact_attack();
        cut = true;
        probability_critical();
        cut = true;
        critical_percentage();

        return calc_base_damage(character_attack, critical_damage_probability, critical_damage_percentage);
    }

    public static double calc_base_damage(double character_attack, double critical_damage_probability,
            double critical_damage_percentage) {

        var_basedamage = character_attack * (1 + critical_damage_probability + critical_damage_percentage);
        return var_basedamage;
    }

    /*
     * Transformative Damage Method {
     * 
     * Description: This method calculates the %bonusEM (Elemental Mastery bonus
     * percentage)
     * based on the previously entered Elemental Mastery. Additionally, with the
     * character's level, chosen transformative multiplier,
     * and resistance multiplier, it calculates the transformative damage.
     * Furthermore, a switch statement is used to obtain the value of the previously
     * entered transformative multiplier.
     * Precondition: The method receives 4 variables and returns a result that
     * affects the global variable total_damage.
     * Postcondition: Affects the global variable total_damage.
     * 
     * @return transformative_damage A float-type variable, the result of the
     * operation using the input data transform_multiplier,
     * character_level, trasformative_multiplier, elemental_mastery, and choice.
     */

    public static double transformative_damage() {

        cut = true;
        elem_mastery();
        cut = true;
        charac_level();
        cut = true;
        transformative_multiplier();
        return calc_transformative_damage(elemental_mastery, character_level, multiplier_eleccion);
    }

    public static double calc_transformative_damage(double elemental_mastery, double character_level,
            double multiplier_eleccion) {
        System.out.println("Selected multiplier transformation: " + multiplier_eleccion);

        bonoME = 16 * (elemental_mastery / (elemental_mastery + 1400)); //
        var_transformativedamage = multiplier_eleccion * character_level
                * ((1 + bonoME) * aleatory_multiresistance());

        System.out.println("damage for character: " + Math.round(var_transformativedamage));// print the damage but
                                                                                            // aproximated

        return var_transformativedamage;
    }

    /*
     * amplificative_damage_method {
     * Description: This method calculates the %bonusME based on the previously
     * entered elemental mastery.
     * Additionally, using the reaction multiplier and %bonusME, along with the
     * previously calculated amplification multiplier plus the base damage,
     * it computes the amplificative damage.
     * Furthermore, a switch statement is used to obtain the value of the previously
     * entered amplificative multiplier.
     * Precondition: The method receives 3 variables and returns a result that
     * affects the global variable total_damage.
     * Postcondition: Affects the global variable total_damage.
     * 
     * @return amplificative_damage A float-type variable, the result of the
     * operation using the input data elemental_mastery, amplification_multiplier,
     * and reaction_multiplier.
     * }
     */
    public static double amplificative_damage() {
        cut = true;
        elem_mastery();
        cut = true; // for start again the loop
        amplificative_multiplier();
        return calc_amplificative_damage(elemental_mastery, reaction_multiplier,
                bonoME);
    }

    public static double calc_amplificative_damage(double elemental_mastery, double reaction_multiplier,
            double bonoME) {
        System.out.println("Selected amplificative multiplier : " + reaction_multiplier);
        bonoME = 2.78 * (elemental_mastery * (elemental_mastery + 1400)); // operation of the amplificative damage
                                                                          // calculation
        multiampli = reaction_multiplier * (1 + bonoME);
        var_amplificativedamage = (base_damage() * multiampli);
        System.out.println("damage for character: " + Math.round(var_amplificativedamage));// print the damage but
                                                                                           // aproximated

        return var_amplificativedamage;

    }

    /*
     * additive_damage_method {
     * Description: This method calculates the %bonusME based on the previously
     * entered elemental mastery. Additionally,
     * using the additive multiplier, %bonusME, character level, and resistance
     * multiplier, it computes the additive damage.
     * Furthermore, a switch statement is used to obtain the value of the previously
     * entered additive multiplier.
     * Precondition: The method receives 4 variables and returns a result that
     * affects the global variable total_damage.
     * Postcondition: Affects the global variable total_damage.
     * 
     * @return additive_damage A float-type variable, the result of the operation
     * using the input data additive_multiplier,
     * trasformative_multiplier, character_level, and elemental_mastery.
     * }*
     * 
     * 
     */
    public static double additive_damage() {
        cut = true;
        elem_mastery();
        cut = true;
        charac_level();
        cut = true;
        additive_multiplier();
        return calc_additive_damage(elemental_mastery, multiplier_eleccion, character_level);
    }

    public static double calc_additive_damage(double elemental_mastery, double multiplier_eleccion,
            double character_level) {
        System.out.println("Selected additive multiplier : " + multiplier_eleccion);
        bonoME = (elemental_mastery * (elemental_mastery + 1200)); // calculate the additive damage
        var_additivedamage = (multiplier_eleccion * character_level * (1 + bonoME)
                * aleatory_multiresistance());
        System.out.println("damage for character: " + Math.round(var_additivedamage));// print the damage but
                                                                                      // aproximated

        return var_additivedamage;
    }

    /*
     * saving_damage method
     * --------------------------------
     * description: let the user can see the contents of the list of damage, print
     * the last 10 damages
     * preconditions: need a list previously saved
     * postcondition: Dont affect global variables
     * 
     * @param <list. damages> the list that contains the damage
     * 
     * @return <> print in screen the last 10 damages in the list
     */
    public static void saving_damage() { // modificadora
        int i = 0;

        if (damages.size() == 0) {
            System.out.println("No damages have been calculated");
            return;
        } else if (damages.size() <= 10) {
            for (i = 0; i < damages.size(); i++) {
                System.out.println("\n Damage " + (i + 1) + ": " + Math.round(damages.get(i))); // print the damages of
                                                                                                // the
                // list (aproximated)
            }

        } else {
            for (i = (damages.size() - 10); i < damages.size(); i++) {
                System.out.println(" Damage " + (i + 1) + ": " + Math.round(damages.get(i))); // print the las 10
                                                                                              // damages of
                // the list (aproximated)
            }

        }

        System.out.println("\n");
        System.out.println("\n");
    }

    /*
     * calc_highestdamage method
     * description: Calcul the highest damage value in the list "damages" and print
     * it in the output
     * precondition: the list "damages"
     * postcondition: Dont affect global variables
     * 
     * @param <list.damages> the list that contains the damage
     * 
     * @return <> print in screen the highest damage value registered in the list
     * "damages"
     */
    public static double calc_highestdamage() { // analizadora
        highestdamage = 0;
        for (int i = 0; i < damages.size(); i++) {

            if (damages.get(i) > highestdamage) { // search for the highest damage in the list
                highestdamage = damages.get(i);
            }
        }
        System.out.println("the highestdamage is " + Math.round(highestdamage)); // print the highest damage
                                                                                 // (aproximated)
        System.out.println("\n");
        System.out.println("\n");
        return highestdamage;
    }

    public static void main(String[] args) {
        boolean cut = true;

        // Scanner txt = new Scanner(System.in);
        System.out.println("welcome to genshin calculator");
        cut = true;
        while (cut) {
            System.out.println(
                    "what action you want to do... \n 1. calculate damage \n 2. see the last 10 damages \n 3. calculate the hightest damage \n 0. Exit");
            // main
            options_menu = txt.nextInt();
            switch (options_menu) { // depending on the action you select, realize a different action
                case 1:
                    System.out.println("\n");
                    System.out.println("Calculating damage");
                    character = 1;
                    count2 = 0;
                    total_damage = 0;

                    while (character != 5) {

                        System.out.println("you want to calculate the damage for character " + character + "?"
                                + "\n 1. yes \n 0. no, exit");
                        options_menu = txt.nextInt();
                        if (options_menu == 1) {
                            System.out.println("\n");
                            System.out.println(
                                    "what type of reaction use your character \n 1. transformative \n 2. amplificative \n 3. additive");
                            count_reaccions = txt.nextInt();
                            if (count_reaccions == 1) {
                                System.out.println("\n");
                                System.out.println("\n");
                                System.out.println("Calculating transformative damage for character " + character);

                                damage = transformative_damage();

                            } else if (count_reaccions == 2) {
                                System.out.println("Calculating amplificative damage for character " + character);

                                damage = amplificative_damage();

                            } else if (count_reaccions == 3) {
                                System.out.println("Calculating additive damage for character " + character);

                                damage = additive_damage();

                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                            }

                            damages.add(damage);
                            total_damage += damage;
                            character += 1;
                            System.out.println("total damage for the moment: " + Math.round(total_damage));
                            System.out.println("\n");
                            System.out.println("\n");
                        } else if (options_menu == 0) {

                            System.out.println("exiting");
                            character = 5;
                            break;

                        } else {

                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }

                    break;
                case 2:
                    saving_damage(); // call the method to print the las 10 damages
                    System.out.println("\n");
                    break;
                case 3:
                    calc_highestdamage(); // call the method to calculate the highest damage
                    System.out.println("\n");

                    break;

                case 0:
                    System.out.println("Exiting");
                    System.out.println("\n");
                    cut = false; // for close

            }
            txt.nextLine();
        }
    }

}
