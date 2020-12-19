
""""""

class PigLatin:
	def __init__(self,):
		userInput = input("enter phrase here and press enter\n:::_")
		self.phrase = userInput
		self.pigLatin = [ ] 
		self.splitPhrase = self.phrase.split()
	def printPigLatin(self):
		for  eachPhrase in self.splitPhrase:
			raw = " "
			char_1 = eachPhrase[0] 
			for i in range(len(eachPhrase)):
				if i ==0:
					pass
				else:
					raw += eachPhrase[i]
			self.pigLatin.append(raw+char_1+"ay")
		print(self.pigLatin)
		return self.pigLatin

