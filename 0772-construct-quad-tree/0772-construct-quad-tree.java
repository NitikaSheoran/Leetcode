/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public boolean isEq(int[][] grid, int sR, int eR, int sC, int eC){
        int num = grid[sR][sC];
        for(int i=sR; i<=eR; i++){
            for(int j=sC; j<=eC; j++){
                if(grid[i][j] != num) return false;
            }
        }

        return true;
    }
    public Node constructTree(int[][] grid, int stRow, int endRow, int stCol, int endCol){
        if(stCol > endCol || stRow > endRow) return null;

        if(isEq(grid, stRow, endRow, stCol, endCol)){
            return new Node(grid[stRow][stCol]  == 1, true);
        }

        int midRow = (stRow + endRow)/2;
        int midCol = (stCol + endCol)/2;


        Node topLeft = constructTree(grid, stRow, midRow, stCol, midCol);
        Node topRight = constructTree(grid, stRow, midRow, midCol+1, endCol);
        Node bottomLeft = constructTree(grid, midRow+1, endRow, stCol, midCol);
        Node bottomRight = constructTree(grid, midRow+1, endRow, midCol+1, endCol);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

    }
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructTree(grid, 0, n-1, 0, n-1);

    }
}