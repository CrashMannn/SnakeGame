/**
*@author crash_man
*@Time 2016-11-01
*/
public enum Direction 
{
	UP(0),DOWN(1),LEFT(2),RIGHT(3);

	private final int directionCode;

	public int directionCode() {
        return directionCode;
    }

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
	public boolean equals(Direction d)
	{
		return d.toString().equals(this.toString());
	}
}
