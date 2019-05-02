if __name__ == "__main__":
    userInputs = []                                 # List for user Inputs

    while True:                                     # Loop to collect user input
        try:
            userInputs.append(input("Enter: "))     # Collects user Input
        except EOFError:                            # Catches EOF and breaks loop to continue with program
            break
    for i in range(len(userInputs)):                # Loop to print out user input backwards
        print(userInputs[len(userInputs)-1-i])
