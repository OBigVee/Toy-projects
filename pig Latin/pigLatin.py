"""
this program encodes English-language phrases into pig Latin. 
Pig Latin is a form of coded language. There are many different ways to form pig Latin phrases.
this application used the following algorithm:
Tokenize the phrase into words.
To translate each English word into a pig Latin word, place the first
letter of the English word at the end of the word and add the letters “ay.” Thus, the word “jump”
becomes “umpjay,” the word “the” becomes “hetay,” and the word “computer” becomes “omputercay.” 
Blanks between words remain as blanks. 
Method printLatinWord display each word. Each token is passed to method printLatinWord 
to print the pig Latin word.
"""


class PigLatin:
	def __init__(self,):
		userInput = input("enter phrase here and press enter\n::")
		self.phrase = userInput
		self.pigLatin = [ ] 
		self.splitPhrase = self.phrase.split()
	def printPigLatin(self):
		for  eachPhrase in self.splitPhrase:
			raw = " "
			char_1 = eachPhrase[0] 
			#[i for i in range(len(eachPhrase)) pass if i== 0 else  raw+=eachPhrase[i]]
			
			for i in range(len(eachPhrase)):
				if (i ==0) :
					pass
				else:
					raw+=eachPhrase[i]
			# 		pass
			# 	else:
			# 		raw += eachPhrase[i]
			self.pigLatin.append(raw+char_1+"ay")
		print(self.pigLatin)
		return self.pigLatin
pigLatin = PigLatin()
pigLatin.printPigLatin()
