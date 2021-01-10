package decor;

public class Component {
    public void operate1() {
        System.out.println("operate1");
    }
}

 class ComponentDecorator extends Component{
    private Component mComponent;

    public ComponentDecorator(Component component) {
        mComponent = component;
    }

     public void operate1() {
         System.out.println("before operate1");
         mComponent.operate1();
         System.out.println("after operate1");
     }
}

class ComponentChild extends Component{
    public void operate1() {
        System.out.println("child operate");
    }
}