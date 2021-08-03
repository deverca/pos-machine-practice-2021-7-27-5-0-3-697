PDCA

printReceipt:
P:6 mins
D: 5m9s
C:1. Find a much more suitable way to manipulate a string.
A:1. I used a StringBuilder so that it's easier for me to manipulate the string to be returned.
generateProductDetails:
P:3mins
D:3m2s
C:
1.I should find a better way to optimize the filtering of the product details
A:
1. I used stream().filter() so that I don't have to create a loop to filter details of a particular bar code

calculateQty:
P:2 mins
D:1m27s
C:1. I should find a better way to get the size of the list instead of looping
A:1. I applied List.size() method to get the quantity.
calculateSubTotal:
P:1 min
D:28 s
C:
A:
calculateTotal:
P:2 mins
D:1m47s
C:1. Search for a better way to sum all the doubles in a list
A:1. I discovered the stream.mapToDouble().sum() function which allows you to sum up all the elements in a list.
generateReceipt:
P:7 mins
D:4m58s
C:
A:

checkPOSMachine
P:10 mins
D:30 mins
C:1. Fix bugs found
A:1. Had to redo most parts of the code since the product details are redundant