public class NBody {
    public static double readRadius(String file_path){
        In in =new In(file_path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in =new In(path);
        int num=in.readInt();
        double r=in.readDouble();
        Planet [] ps=new Planet[num];
        for(int i=0;i<num;i++){
            double x=in.readDouble();
            double y= in.readDouble();
            double xv=in.readDouble();
            double yv=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            ps[i]=new Planet(x,y,xv,yv,m,img);
        }
        return ps;
    }
    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        Planet[] planets=readPlanets(filename);
        for(Planet p :planets){
            p.draw();
        }
        int n=planets.length;
        double t=0;
        while(t<T){
            t+=dt;
            double[] fxs=new double [n];
            double[] fys=new double [n];
            for (int i=0;i<n;i++){
                fxs[i]=planets[i].calcNetForceExertedByX(planets);
                fys[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for(int i=0;i<n;i++ ){
                planets[i].update(dt,fxs[i],fys[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p:planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}



