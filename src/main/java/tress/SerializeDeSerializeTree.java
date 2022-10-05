package tress;

public class SerializeDeSerializeTree {

    /*
    Serialize will print nodes in Pre Order
    It will print -1 in place of null as we want deserialize later
     */
    public static void serialize(BTNode root, StringBuffer s) {
      if (root == null) {
          s.append("-1,");
          return;
      }
      s.append(root.data).append(",");
      serialize(root.getLeft(), s);
      serialize(root.getRight(), s);
    }
    

    public static void main(String[] args) {
        BTNode root = BinaryTreeUtils.createSimpleBinaryTree();
        StringBuffer sb= new StringBuffer("");
        serialize(root, sb);
        System.out.println(sb.toString());
        String[] s = sb.toString().split(",");
    }
}
