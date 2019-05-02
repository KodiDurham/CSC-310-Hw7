def perm_list(ulist, swap, lLength):                        # this takes a list, an swapping point, and length of list
    if swap == lLength:                                     # This checks if its and the end of branch and prints output
        print(*ulist, sep="")
    else:
        for i in range(swap, lLength):                      # loop to get various permutations
            ulist[i], ulist[swap] = ulist[swap], ulist[i]   # Swapping objects to get the permutations
            perm_list(ulist, swap + 1, lLength)             # recurs changing swap index to to go further down a branch
            ulist[i], ulist[swap] = ulist[swap], ulist[i]   # Swapping back objects after completing that part of branch


if __name__ == "__main__":
    while True:
        try:                                            # Gets input from user and then check eofError
            uInput = input("What do you want to get permutations of? ")
            perm_list(list(uInput), 0, len(uInput))     # Calls function to print permutations
            print()
        except EOFError:                            # Lets user decide when to end program by use of end of file command
            break
