public class User {
    private int rank;
    private int progress;
    
    public User() {
        rank = -8;
        progress = 0;
    }

    public int getRank() {
        return this.rank;
    }

    public int getProgress() {
        return this.progress;
    }

    public void incProgress(int rank) {
        if (rank < -8 || rank > 8 || rank == 0) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (this.rank == 8) {
            return;
        }
        int diff = rank - (this.rank == 0 ? this.rank + 1 : this.rank);
        if (diff == -1) {
            this.progress++;
        } else if (diff == 0) {
            this.progress += 3;   
        } else if (diff > 0) {
            this.progress += (10*diff*diff);
        }
        while (this.progress > 99) {
            this.progress -= 100;
            this.rank++;
            if (rank == 8) {
                this.progress = 100;
                return;
            }
            if (this.rank == 0) {
                this.rank++;
            }
        }
    }

    public String toString() {
        return "User{rank=" + this.rank + ", progress=" + this.progress + "}";
    }


}
