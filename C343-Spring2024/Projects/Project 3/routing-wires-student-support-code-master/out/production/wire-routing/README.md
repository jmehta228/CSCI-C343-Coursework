1. The four functions we are implementing and that are being used in Routing.java are findPaths (which returns a list of 
wires and takes in a board and list of endpoints), bfs (implementing a breadth first search, returning a boolean true or 
false and takes in a board, one endpoints object, and a hashmap of coord to coord), returnWire (which returns a wire and 
takes in a board and one endpoints object), and backtracking (which returns a list of wires, and takes in a board, and 
list of endpoints). The findPaths function uses the backtracking function and returns the backtracking function output 
with the board and list of endpoints as the function call input. The bfs function implements Breadth-First Search to 
traverse a board represented as a graph. It starts at the designated start point and explores neighboring points 
level by level, gradually increasing the search until it finds the endpoint or exhausts all possible paths. Utilizing a 
queue data structure, it efficiently explores unvisited vertices, updating a mapping of each vertex to its parent to 
reconstruct the path if found. This BFS approach ensures that the shortest path from start to end, considering the 
specific constraints defined by the board, is efficiently determined. The returnWire function efficiently finds and returns 
a wire connecting two endpoints on a board. It first initializes a HashMap to store the mapping of coordinates. Then, it 
employs the BFS algorithm to search for a path between the given endpoints. If a path is found, it constructs the wire 
by tracing back through the coordinates using the mapping created during the BFS search. The wire is then placed on the 
board, and the algorithm returns the constructed wire. If no path is found, it returns null. Overall, this method 
orchestrates the process of wire creation, utilizing BFS for pathfinding and managing the wire's placement on the board. 
The backtracking function uses backtracking to find a set of wires connecting multiple endpoints on a board. It begins 
by checking if there are any remaining goals (endpoints) to connect. If not, it returns an empty list of wires. 
Then for each endpoint it tries to create a wire using the returnWire function. If it does work, it removes that 
endpoint from the list of goals and recursively calls itself with the updated list. If the recursion returns null, 
which means it did not work, it removes the wire from the board. Otherwise, it adds the wire to the result list and 
returns it. This process continues until either all endpoints are connected or no valid wires can be placed, 
in which case it returns null. Overall, the algorithm explores different combinations of wires, 
using backtracking to efficiently find a solution.
2. Sample board\
   1\
   6\
   0\
   3\
   0 0 1 0\
   0 2 0 3\
   0 4 0 5
3. This backtracking algorithm efficiently connects endpoints on a board by iteratively attempting to lay wires between 
them. It systematically explores different wire combinations, removing invalid attempts while constructing a list of 
connected wires. If successful, it returns a list of wires meeting the goals; otherwise, it returns null. This recursive 
approach optimally handles various layouts and constraints, ensuring robustness and adaptability in wire layout 
optimization.
4. 