class HammeringD:                           # a class that takes two points converts them to binary and then checks the
                                            # differences in the binary numbers
    def __init__(self, x, y):               # constructor that takes x and y and stores them and also stores the binary
        self._x = x
        self._y = y
        self._xbin = self.to_binary(x)      # stores binary of x
        self._ybin= self.to_binary(y)       # stores binary of y

    def get_x(self):                        # the gets of the class to make class reusable and expandable
        return self._x

    def get_y(self):
        return self._y

    def get_xbin(self):
        return self._xbin

    def get_ybin(self):
        return self._ybin

    @staticmethod
    def to_binary(num):                     # static method that takes and int and returns the binary in str
        binary = ""
        while num > 0:
            binary = str(num % 2) + binary
            num = int(num/2)
        return binary

    def hamming_d(self):                    # the function to call to get the difference of the ints provided
        count = 0                           # a count of the differences
        list_x = list(self._xbin)           # converts the str of binary to lists
        list_y = list(self._ybin)

        big = max(len(list_x), len(list_y))     # find the number with the biggest length and stores it

        for i in range(len(list_x), big):       # makes sure both lists are the same length
            list_x.insert(0, "0")

        for i in range(len(list_y), big):
            list_y.insert(0, "0")

        for i in range(big):                    # checks the same index of both lists for difference
            if list_x[i] != list_y[i]:
                count += 1
        return count                            # return difference


if __name__ == "__main__":
    while True:
        try:                                    # collects user inputs and makes sure it is an int
            uInput_1 = int(input("Enter your x integer: "))
            break
        except ValueError:
            print("Not an integer")
    while True:
        try:
            uInput_2 = int(input("Enter your y integer: "))
            break
        except ValueError:
            print("Not an integer")

    h_d = HammeringD(uInput_1, uInput_2)        # declares object and print out the hammering distance

    print("The hammering distance between ", uInput_1, " and ", uInput_2, " is ", h_d.hamming_d())
