# Graph Cycle Detection using Depth-First Search (DFS)

This project was developed as part of the **Algorithms: Theory, Design and Implementation (5SENG003C.2 / 5SENG003W)** coursework at the **University of Westminster / Informatics Institute of Technology**.  

The aim of this coursework is to implement an algorithm to check whether a given directed graph is **acyclic**. If the graph contains a cycle, the program detects and outputs the cycle. The implementation is done in **Java**, using the **Depth-First Search (DFS)** algorithm.

---

## 📌 Features
- Representation of directed graphs using efficient Java data structures (`HashMap`, `HashSet`, `ArrayList`).
- Input parser to read graph edges from a file.
- Cycle detection using **DFS with recursion** and backtracking.
- Produces detailed output, showing traversal and detected cycles.
- Benchmark tests on **acyclic** and **cyclic** examples.
- Includes **performance analysis** (time and space complexity).

---

## 📖 Coursework Context
This project addresses the following coursework tasks:

1. **Project Setup** – Java project setup and structure.  
2. **Data Structures** – Graph representation using adjacency lists.  
3. **Input Parser** – Reads graph data from text files containing pairs of numbers (edges).  
4. **Algorithm Implementation** – Determines if the graph is acyclic using DFS.  
5. **Cycle Detection** – Outputs a cycle if found in the graph.  
6. **Report** – Explains choice of algorithm and data structures, benchmarks, and complexity analysis.  

---

## 🛠️ Technologies Used
- **Programming Language**: Java (JDK 8+)
- **Core Data Structures**:
  - `HashMap<Integer, ArrayList<Integer>>` → For adjacency list representation of graphs
  - `HashSet<Integer>` → For tracking visited vertices and current recursion stack
  - `ArrayList<Integer>` → For storing detected cycles and neighbor lists
 
---

## 🛠️ Implementation Details

Algorithm
- Depth-First Search (DFS): Chosen for its efficiency in cycle detection and memory optimization
- Time Complexity: O(|V| + |E|) where V is vertices and E is edges
- Space Complexity: O(|V|) in worst case due to recursion stack

---

## 📂 Project Structure
```
Algo_Coursework/ 
├── src/ 
│   ├── Main.java 
│   ├── AcyclicDetector.java 
│   ├── DirectedGraph.java 
│   ├── GraphParser.java 
│   └── graphInfo.txt 
├── w1867067_algo_report.docx 
├── w1867067_algo_report.pdf 
└── README.md 
```
---

## 📥 Installation & Usage

### Prerequisites
- Java JDK 17 or higher
- Git (for cloning the repository)

---

## ▶️ Running the Project

### 1. Clone the repository
```
git clone https://github.com/SandeepaInduwaraSamaranayake/Acyclic_graph_detector.git
cd Acyclic_graph_detector
```

### 2. Compile the Java files
```
javac src/*.java
```

### 3. Create/ edit text file with edges in the following format
```
source_vertex target_vertex
source_vertex target_vertex
```
Example:
```
1 2
2 3
3 1
```

### 4. Run the program
```
java -cp src Main
```

---
## 📊 Example Outputs

### 🔄 Acyclic Graph Detection

#### Input Graph Data:
![Input Graph Data](https://github.com/SandeepaInduwaraSamaranayake/Acyclic_graph_detector/blob/main/screenshots/1.PNG)

#### DFS Traversal Process:
![DFS Traversal Process](https://github.com/SandeepaInduwaraSamaranayake/Acyclic_graph_detector/blob/main/screenshots/2.PNG)

### 🔁 Cyclic Graph Detection

#### Input Graph Data:
![DFS Traversal Process](https://github.com/SandeepaInduwaraSamaranayake/Acyclic_graph_detector/blob/main/screenshots/3.PNG)

#### DFS Traversal & Cycle Detection::
![DFS Traversal Process](https://github.com/SandeepaInduwaraSamaranayake/Acyclic_graph_detector/blob/main/screenshots/4.PNG)

---

## 👨‍💻 Developer
- Sandeepa Induwara Samaranayake
- IIT No: 20210302
- UOW No: w1867067
- BEng (Hons) Software Engineering
- Informatics Institute of Technology / University of Westminster
---

## 📄 License
This project was developed for educational purposes as part of university coursework and open sourced under MIT license.
