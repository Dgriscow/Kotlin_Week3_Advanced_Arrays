fun main() {
    var inventoryNames = arrayOf<String>("Buns", "Ketchup", "Mustard", "Dogs", "Relish", "Onions")

    var inventoryValues = arrayOf<String>("55", "20", "25", "50", "80", "30")

    //single variable to be both inventories

    var organizedInventory = arrayOf<Array<String>>(inventoryNames, inventoryValues)

    //value to store the users Entries

    var userEntry:String = ""

    //program remains running unless error Encountered
    do{

        for (id in organizedInventory[0].indices){
            //print the inventory in organized manner
            println("${organizedInventory[0][id]} ${organizedInventory[1][id]}")

        }
        println("\nEnter the Name of A Inventory Item You Wish To Edit \n\nOr Type Exit to Leave: ")
        userEntry = readln()

        //check whether the user entered a valid inventory item

        if (organizedInventory[0].contains(userEntry)){

            var itemNameID = organizedInventory[0].indexOf(userEntry)



            print("You Selected Item: ${organizedInventory[0][itemNameID]}: Which has: ${organizedInventory[1][itemNameID]} Items in Storage\n")
            println("How Would you like to Edit the Item? \n1:Add To Count \n2:Remove Amount")

            //re ask for the users choice, then depending on the number they enter preform a specific action
            userEntry = readln()

            if (userEntry == "1"){

                //ask the User How Much They Want To Add
                println("How Many New Items Do you Have?")
                val newAddAmount = readln().toInt()

                //get the old amount
                val oldAmount = organizedInventory[1][itemNameID]

                val newAmount:Int = oldAmount.toInt() + newAddAmount

                //make the old amount the new amount
                organizedInventory[1][itemNameID] = newAmount.toString()

                println("New Amount for ${organizedInventory[0][itemNameID]}: ${organizedInventory[1][itemNameID]}")


            }else if (userEntry == "2"){

                //ask the User How Much They Want To Add
                println("How Many  Items Do you Want To Remove?")

                val newSubtractAmount = readln().toInt()

                //get the old amount
                val oldAmount:String = organizedInventory[1][itemNameID]

                val newAmount = oldAmount.toInt() - newSubtractAmount

                //check the new amount and make sure its not at or below 0

                if (newAmount <= 0 ){
                    println("Item amount would go under Zero, Setting to Zero")

                    organizedInventory[1][itemNameID] = "0"


                }else{

                    organizedInventory[1][itemNameID] = newAmount.toString()

                }

            }else{
                println("Invalid Selection, Please Try Again")
            }


        }else{
            println("Invalid Entry")
        }





    }while (!userEntry.contains("exit", ignoreCase = true))

}







