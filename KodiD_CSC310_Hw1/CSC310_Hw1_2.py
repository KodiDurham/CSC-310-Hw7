def test_list():
    if len(userInputs) == 1 or len(userInputs) == 0:    # checks if there is no products
        return False
    for i in range(len(userInputs)):                # Loops through the list for each int and checks products
        for j in range(i+1, len(userInputs)):
            if ((userInputs[i]*userInputs[j]) % 2) == 1:
                return True                         # True meaning there is an odd product
    return False                                    # False meaning there is not an odd product


if __name__ == "__main__":
    userInputs = []                                 # List for user Inputs

    while True:                                     # Loop to collect user input
        try:
            try:
                uInput = int(input("Enter integer: "))
                userInputs.append(uInput)
            except ValueError:                      # Catches non int values
                print("Not a integer please try again")
        except EOFError:                            # Catches EOF and breaks loop to continue with program
            break

    if test_list():                     # Determines if it has an odd product or not and tells user
        print("There is an odd product")
    else:
        print("There is not an odd product")