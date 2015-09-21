public class scratch
{
	        final Mapper map1 = new Mapper() 
	        {
            	public void map(String key, String value, MapReduce mr)
            	{
                	mr.collect_map("line", list("1"));
               	} 
            };

        final Reducer red1 = new Reducer() 
        {
            public void reduce(String key, Cons value, MapReduce mr)
            {
                // System.out.println("  red1 key = " + key + "  val = " + value.toString());
                int sum = 0;
                for ( Cons lst = value; lst != null; lst = rest(lst) )
                {
                	sum += Integer.decode( (String) first( (Cons) first(lst) ) );
                }
                
                mr.collect_reduce(key, new Integer(sum)); 
            } 
        };
}