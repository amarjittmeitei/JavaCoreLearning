package com.core.MemAllocationBasic;

public class ObjectInfo {

    int rollNo;
    double marks;
    char section;


    /*
        In java, when we write
        ObjectInfo ob = new ObjectInfo();

        the ob is the reference variable and the new ObjectInfo() is the object
        ob store in stack memory hold 4 bytes or 8 bytes to store according to the JVM
        new ObjectInfo() store in the heap memory

        The size of the object include
            1. Header size / object header
            2. Exact fields
            3. Padding

        1. Header size / object header
            This object header store
                1.1 Metadata include
                    1.1.1 Mark words
                        To store the mark word 8 bytes of memory is used
                        This mark words store the details about the object include
                        1.1.1.1 Details of locking mechanism
                        1.1.1.2 Information about Synchronization
                        1.1.1.3 Information about Garbage collection
                        ... and more

                    1.1.2 Class pointer
                        To store the class pointer 4 bytes or 8 bytes of memory
                        used depends on the JVM

                        This store the reference of the object like the reference
                        variable does. It is used to use the "this" keyword.

        2. Exact fields
            This store the variables of the class the object belongs.
            So, the size of the Exact filed depends on the content of the class
            in our class ObjectInfo we have,
                int rollNo; -> 4 bytes
                double marks; -> 8 bytes
                char section; -> 1 bytes
            The total of 13 bytes of memory for exact fields used

        3. Padding
            The modern CPU takes 8 bytes of chunks data to execute. So the size of
            our objects need to be the multiple of 8.
            To satisfy this condition padding is used make the size of object is
            multiple of 8.

            In our case
                The object header used 12 bytes of memory
                The exact field used 13 bytes of memory
                So, in total 25 bytes of memory is used. But 25 is not a multiple
                of 8. Nearest multiple of 8 greater than 25 is 36. To make the
                size of our object multiple of 8, the padding of 11 bytes is to be
                added.
    */
}
