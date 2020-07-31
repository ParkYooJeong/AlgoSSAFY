package kakao;

class ConstructionRacetrack {
    public int solution(int[][] board) {
        int answer = 0;
        int [][] cost = new int [board.length][board.length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
            	cost[i][j] = 100000000;
            }
        }
        
        cost[0][0] = 0;
        
        dfs(0, 0, 0, cost, board);
        dfs(0, 0, 1, cost, board);
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
            	System.out.printf("%-11d", cost[i][j]);
            }
            System.out.println();
        }
        
        
        answer = cost[board.length-1][board.length-1];
       
        
        return answer;
    }
    
    
    public void dfs(int x, int y, int direction, int[][] cost, int[][] board) { // direction 0:���ι���, 1:���ι���
    	
    	int dx[] = {0, 1, 0, -1};
    	int dy[] = {1, 0, -1, 0};
    	
    	// 1. ������ �����Ѱ��
    	if(x == cost.length-1 && y == cost.length-1) {
    		return;
    	}
    	
    	for(int i=0; i<4; i++) { // i�� 0�̸� ���� i�� 1�̸� ����
    		
    		int rx = x+dx[i];
    		int ry = y+dy[i];
    		
    		// System.out.println(i+" : "+rx +", " + ry + " / " + direction);
    		
    		if(rx < board.length && ry < board.length && rx >= 0 && ry >= 0) { // ���ַθ� ����� �ʴ� ���
    			if(board[rx][ry] == 0) { // ���� �ƴ� ���
    				if(i%2 == direction) { // ���� �����ΰ��
    					
    					int a = cost[rx][ry];
    					int b = cost[x][y]+100;
    					if(a >= b) {
    						cost[rx][ry] = b;
    						dfs(rx, ry, i%2, cost, board);
    					}
    					
    				} else { // �ڳ��� ���
    					
    					int a = cost[rx][ry];
    					int b = cost[x][y]+600;
    					if(a >= b) {
    						cost[rx][ry] = b;
    						dfs(rx, ry, i%2, cost, board);
    					}
    				}
    			}
    		}
    	}

    }
}