import math 
class BankAccount:
    def __init__ (self,accountName,accountId):
        self.bal = 0
        self.previousTransaction = 0
        self.accountName = accountName
        self.accountId = accountId

    def deposit(self,amount):
        if amount!=0:
            print('your account has be credited with $'+str(amount))
        else:
            print('you can\'t deposit $'+str(amount))
    def withdraw(self,amount):
        print(self.bal)
        if self.bal < amount:
            print('insufficient funds')
        else:
            
            self.bal = self.bal - amount 
            self.previousTransaction = - amount
            print('balance == '+ str(self.bal))
            print('Debit alert!\n your account has been debitted')
            print('\n')
            #return bal
    def  getPreviousTransaction(self):
        if(self.previousTransaction>0):
            print('deposited\t'+str(previousTransaction))
        elif(self.previousTransaction<0):
            print('withdrawn '+math.abs(previousTransaction))
        else:
            print('no transaction')
            
    # def getPreviousTransaction():
    #    if(previousTransaction>0):
    #         print('depositted '+ str(previousTransaction))

    #     elif (previousTransaction < 0):
    #         print('withdrawn '+ math.abs(previousTransaction))
        
    #     else:
    #         print('no transaction made')

    def bankMenu(self):
        print('welcome' + self.accountName)
        print('your account number is '+ self.accountId+'\n')
        print('the following option performs corresponding tasks\n')
        print("A : Check balance \n B : Deposit \n C : withdraw \n D : check Previous transactions \n E : Exit")
        # selectOption = input("select an option to perform an action")
        selectOption = ''
        while True:
            selectOption = input("select an option to perform an action")
            if selectOption == "A":
               print('Balance'+str(self.bal))
            elif selectOption == "B":
                amount = int(input ('enter amount to deposit'))
                self.deposit(amount)
                print("$"+str(amount)+' Deposited'+'\n')

            elif selectOption =="C":
                amount2 = int(input('enter amount to withdraw'))
                self.withdraw(amount2)
                print('your account has been deitted'+'\n')

            elif selectOption == "D":
                self.getPreviousTransaction()
                print('\n')
            else:
                if selectOption =="E":
                    print('exiting app in sec..')
                    break
            

firstbank = BankAccount('juliet','9080')
firstbank.bankMenu()