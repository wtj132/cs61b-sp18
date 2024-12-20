public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    /*
    1.static 在类加载时初始化
    2.final 既可以在编译时初始化，也可以在运行时初始化，初始化后不能改变
    3.static final
    * */
    private static final double G=6.67e-11;

    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow(this.xxPos-p.xxPos,2)+Math.pow(Math.abs(this.yyPos-p.yyPos),2));
    }

    public double calcForceExertedBy(Planet p){
        return G*this.mass*p.mass/Math.pow(calcDistance(p),2);
    }

    public double calcForceExertedByX(Planet other) {
        double dist = calcDistance(other);
        double force = calcForceExertedBy(other);
        return (other.xxPos - this.xxPos) / dist * force;
    }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos-this.yyPos)/calcDistance(p);
    }
    public boolean equals (Planet p){
        return this.calcDistance(p) == 0;
    }
    public double calcNetForceExertedByX(Planet[] ps){
        double total_force=0;
        for(Planet p :ps){
            if(this.equals(p)) continue;
            total_force+=this.calcForceExertedByX(p);
        }
        return total_force;
    }
    public double calcNetForceExertedByY(Planet[] ps){
        double total_force=0;
        for(Planet p :ps){
            if(this.equals(p)) continue;
            total_force+=this.calcForceExertedByY(p);
        }
        return total_force;
    }
    public void update(double dt,double fx,double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
        this.xxVel+=ax*dt;
        this.yyVel+=ay*dt;
        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }


}


