public class Points {
		int x1 = 0, x2 = 0, y2 = 0, y1 = 0;

		Points(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y2 = y2;
			this.y1 = y1;
		}

		public String toString() {
			return "x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2;
		}
	}