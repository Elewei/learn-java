package array;

/**
 * Grid.java
 * 开发者： 张启卫
 * 程序功能： 求解和为15的棋盘游戏问题
 *   描述：将从1到9的九个数字不重复地填入3X3的棋盘中，
 *   使得各行、各列以及两个对角线上的3个数之和均为15
 *   
 * @author David
 *
 */

public class Grid {
	
	int [][] m_board;
	
	public Grid() {
		m_board = new int [3][3];
	}
	
	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.mb_arrange();
	}
	

	
	/*
	 * 输出棋盘的格线行
	 * 调用mb_outputGridRowBoard()
	 * 输出结果：+-----+
	 * 
	 */
	private void mb_outputGridRowBoard() {
		System.out.print("+");
		for (int i=0; i<5; i++)
			System.out.print("-");
		System.out.println("+");
	}
	
	/*
	 * 输出棋盘的数据行（第i行，i只能为0， 1，或2）
	 * 调用mb_outputGridRowBoard(int i)
	 * 输出结果：|x|x|x|
	 * x为第i行中棋盘中相应的数字
	 *  
	 */
	private void mb_outputGridRowBoard(int i) {
		for(int j=0; j<m_board[i].length; j++)
			System.out.print("|" + m_board[i][j]);
		System.out.println("|");
	}
	
	/*
	 * 输出棋盘
	 * 调用mb_outputGrid()
	 * 输出 
	 *   +-----+
	 *   |x|x|x|
	 *   +-----+
	 *   |x|x|x|
	 *   +-----+
	 *   |x|x|x|
	 *   +-----+
	 *   
	 *   x为现有棋盘中的数据
	 */
	public void mb_outputGrid() {
		mb_outputGridRowBoard();
		for (int i=0; i<m_board.length; i++) {
			mb_outputGridRowBoard(i);
			mb_outputGridRowBoard();
		}
	}
	
	/*
	 * 初始化数据 :
	 *  1 2 3
	 *  4 5 6
	 *  7 8 9
	 *  
	 */
	private void mb_dataInit() {
		int k = 1;
		//System.out.println(m_board.length);
		for(int i=0; i<m_board.length; i++)
			for(int j=0; j<m_board[i].length; j++)
				m_board[i][j] = k++;
	}
	
	/*
	 * 数据结束检测 
	 * 返回值说明：
	 *   当数据为最后一个数据时，返回true; 
	 *   否则返回false
	 *   
	 * 说明：程序递增是从最后一位开始递增
	 * 当第一个数字为9时，则程序为最后一个
	 * 
	 * 
	 */
	private boolean mb_dataEnd() {
		for(int i=0, k=9; i<m_board.length; i++)
			for(int j=0; j<m_board[i].length; j++, k--)
				if(m_board[i][j] != k)
					return false;
		return true;
	}
	
	/*
	 * 取下一个数据
	 *  数据从最后一位开始递增，每递增一位返回
	 */
	private void mb_dataNext() {
		for (int i=m_board.length-1; i>=0; i--)
			for(int j=m_board[i].length-1; j>=0; j--)
				if(m_board[i][j] == 9)
					m_board[i][j] = 1;
				else 
				{
					m_board[i][j]++;
					return;
				}
	}
	
	/*
	 * 数据检测： 判断数据中是否含有相同的数字
	 * 当数据中存在相同数字时，返回false
	 * 否则返回true
	 * 
	 * 说明：利用1到9个数只能在棋盘中出现一次，当出现一次这个值，
	 *      digit中数组相应位置计数为加1
	 *      当和为9值，即9个1，则为没有相同的数字
	 *      否则则有
	 */
	private boolean mb_dataCheckDifferent() {
		int [] digit = new int [10];
		int i,j,k = 0;
		for (i=0; i<m_board.length; i++)
			for (j=0; j<m_board[i].length; j++)
				digit[m_board[i][j]] = 1;
		
		for (i=1; i<digit.length; i++)
			k += digit[i];
		if(k == 9) return true;
		return false;
	}
	
	/*
	 * 数据检测： 各行和是否为15
	 * 当各行和均为15时，返回true
	 *  否则返回false
	 */
	private boolean mb_dataCheckSumRow() {
		for (int i=0; i<m_board.length; i++) {
			int k = 0;
			for(int j=0; j<m_board[i].length; j++)
				k += m_board[i][j];
			if(k != 15) return false;
		}
		return true;
	}
	

	/*
	 * 数据检测： 各列和是否为15
	 * 当各列和均为15时，返回true
	 *  否则返回false
	 */
	private boolean mb_dataCheckSumColumn() {
		for (int i=0; i<m_board.length; i++) {
			int k = 0;
			for(int j=0; j<m_board[i].length; j++)
				k += m_board[j][i];
			if(k != 15) return false;
		}
		return true;
	}
	
	/*
	 * 对棋盘数据检测：
	 *  当数据满足以下情况时，则为棋盘解：返回true
	 *    1. 数据中不得有重复
	 *    2. 一行数据和15
	 *    3. 一列数据和15
	 *    4. 正反斜角和为15
	 *    
	 *  否则返回false
	 */
	private boolean mb_dataCheck() {
		if(!mb_dataCheckDifferent()) return false;
		if(!mb_dataCheckSumRow()) return false;
		if(!mb_dataCheckSumColumn()) return false;
		if(m_board[0][0] + m_board[1][1] + m_board[2][2] != 15) return false;
		if(m_board[0][2] + m_board[1][1] + m_board[2][0] != 15) return false;
		
		return true;
	}
	
	/*
	 *  求解并输出棋盘问题
	 *  第一步：初始化棋盘
	 *  	1 2 3 
	 *      4 5 6
	 *      7 8 9
	 *  第二步：判断是否为最后一个数据
	 *  
	 */
	public void mb_arrange() {
		int n = 1;
		for(mb_dataInit(); !mb_dataEnd(); mb_dataNext()) {
			if(mb_dataCheck()) {
				System.out.println("第" + n + "个结果： ");
				n++;
				mb_outputGrid();
			}
		}
	}
	
	
}
