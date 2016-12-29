import crypt, sys

# Salt and password got from cranb-jessie image shadow file
salt = '$6$2AXLbEoG$'
tocrack = '$6$2AXLbEoG$zZlWSwrUSD02cm8ncL6pmaYY/39DUai3OGfnBbDNjtx2G99qKbhnidxinanEhahBINm/2YyjFihxg7tgc343b0'

# Got this from /usr/share/dict/words
words = [line.rstrip('\n') for line in open('english_dict')]

# Tries all works in the dictionary, then combine 2-by-2 (will take 9 billion comparisons, so give up after that =P)
#for w in words:
#  if tocrack == crypt.crypt(w, salt):
#    print "Found: %s" % w
#    sys.exit(0)
#
print 'Did not work with one word, trying two-by-two'

# Let's try two directions: top-down, down-top
start = 0
end = len(words) - 1
rangew = range(0, end)
turn = -1
index = start

while True:
  nextw = words[index]

  for sufix in rangew:
    w = "%s%s" % (nextw, words[sufix])

    if tocrack == crypt.crypt(w, salt):
      print "Found: %s" % nextw
      sys.exit(0)

  if index == len(words) - 1:
    print "Nothing found =/"
    sys.exit(-1)

  if turn == -1:
    index = end
    start = start + 1
    turn = 1
  else:
    index = start
    end = end - 1
    turn = -1

