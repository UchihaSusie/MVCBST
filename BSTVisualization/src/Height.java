public class Height {
		int root, left, right;

		Height() {
			this.root = 0;
			this.left = 0;
			this.right = 0;
		}

		Height(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return Integer.toString(this.root);
		}

	}
