
public class problems {

	
	/*A)
    A B C D E F 
-- |----------------- 
A |     1   1
B |     1     1
C | 1 1   1   1
D |     1     1
E | 1         1
F |   1 1 1 1



B)                                      
Vertex Adjacency-list             
A      [C E]                      
B      [C F]                        
C      [A B D F]                        
D      [C F]                        
E      [A F]   
F      [B C D E] 

             
C)  [B C A E F D] 
D)  [B C F A D E]  

      
E) 
L - a list that contains visited vertices 
Q - a queue that contains eligible vertices

while Q is non empty
remove a vertex v from Q
add v to the end of L
for each v check if it is has any incoming edges
if it has incoming edges not a root
add to L 
if it doesn't have any incoming edges
use a BFS to determine all reachable vertices and if the result
of that search is equal to the input than it is the root.
else if every vertex has been visited there is no root

This algorithm has a time Complexity of O(2*Vertices + Edges)




*/
	
	
}
