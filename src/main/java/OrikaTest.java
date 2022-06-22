//import com.DestOrika;
//import com.SourceOrika;
//import ma.glasnost.orika.MapperFacade;
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//
//public class OrikaTest {
//    public static void main(String[] args) {
//        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        mapperFactory.classMap(SourceOrika.class, DestOrika.class).byDefault();
//
//        //SourceOrika sourceOrika = new SourceOrika("aman", "23");
//
//        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
//        DestOrika map = mapperFacade.map(sourceOrika, DestOrika.class);
//        System.out.println(map.toString());
//
//    }
//}
