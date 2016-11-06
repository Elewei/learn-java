package tanke2;

//坦克类
class Tank
{
	int x = 0;		//表示坦克的横坐标
	int y = 0;		//表示坦克的纵坐标
	
	//坦克的速度
	int speed = 1;
	
	//颜色
	int color;
		
	// 坦克方向
	// 0 表示 向上
	// 1 表示 向下
	// 2 表示 向左
	// 3 表示 向右
	 
	int direct = 0;		//坦克头指的方向
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	Tank(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
}


//我的坦克
class Hero extends Tank
{
	public Hero(int x, int y)
	{
		super(x, y);
	}
	
	//坦克向上的速度
	public void moveUp()
	{
		this.y -= speed;
	}
	
	//坦克向下的速度
	public void moveDown()
	{
		this.y += speed;
	}
	
	//坦克向左的速度
	public void moveLeft()
	{
		this.x -= speed;
	}
	
	//坦克向右的速度
	public void moveRight()
	{
		this.x += speed;
	}	
}

//敌人的坦克
class EnemyTank extends Tank
{
	public EnemyTank(int x, int y) {
		super(x, y);
	}
}







