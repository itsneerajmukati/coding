public class Test {


    public static void main(String[] args) {
        String val = "neerajmukati";

        NodeString left = new NodeString(null,6,new NodeString("nee",3,null,null),new NodeString("raj",3,null,null));
        NodeString right = new NodeString(null,6,
                new NodeString(null,2,
                        new NodeString("m",1,null,null),new NodeString("u",1,null,null)),
                new NodeString(null,4, new NodeString("kati",4,null,null),null));
        NodeString root = new NodeString(null,12,left,right);
        StringBuilder sb = new StringBuilder();
        substring(root,2,8,0,root.getLen()-1,sb);
        System.out.println(sb.toString());
    }

    private static void substring(NodeString node, int start, int end, int rangeStart, int rangeEnd, StringBuilder result) {
        System.out.println("start: "+start + " end: "+end + " rangeStart: " + rangeStart + " rangeEnd: " + rangeEnd);
        System.out.println(result.toString());

        if(node != null && node.getVal() != null)  {
            if(start > rangeStart && start <= rangeEnd) {
                String val =  node.getVal();
                result.append(node.getVal().substring(start-rangeStart));

            }else if(start < rangeStart && end >= rangeEnd) {
                if(end == rangeEnd) {
                    result.append(node.getVal().substring(0,node.getVal().length()-1));
                }else
                    result.append(node.getVal());

            }else if(start < rangeStart && end < rangeEnd) {
                result.append(node.getVal().substring(0, end-start-result.length()));

            }
        }
        if(result.toString().length() == (end-start)) {
            return;
        }
        if(node !=null && node.getVal() == null) {
            substring(node.left,start,end,rangeStart,rangeStart+node.getLeft().getLen()-1,result);
            substring(node.right,start,end,rangeStart+node.getLeft().getLen(),rangeEnd,result);
        }


    }

}
class NodeString {
    String val;
    Integer len;
    NodeString left;
    NodeString right;

    public NodeString(String val, Integer len, NodeString left, NodeString right) {
        this.val = val;
        this.len = len;
        this.left = left;
        this.right = right;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public NodeString getLeft() {
        return left;
    }

    public void setLeft(NodeString left) {
        this.left = left;
    }

    public NodeString getRight() {
        return right;
    }

    public void setRight(NodeString right) {
        this.right = right;
    }
}