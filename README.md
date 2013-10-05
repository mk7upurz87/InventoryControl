InventoryControl
================

##Description
Develop an inventory control solution that mimics the features of Quickbooks but does not carry the heavy weight setup and UI that it comes with.  We will design and deliver a product that can take in a list of parts and provide an interface that will allow addition and subtraction of these parts.  Furthermore the inventory control application will yield automated alerts to the inventory administrator (defined by ROptions) when there is a quantity of 0 on any part.  This is an event driven system that will remain lightweight and simple to use.  The user interface must be viewable online through their website and login.  This system will be of an enterprise format, all documentation on how to install the system will be provided upon completion.

##Installation
To use this project, you'll need the standalone Play Framework in the same folder as the root folder of this repository. To do this, grab and unzip <a href="http://downloads.typesafe.com/play/2.2.0/play-2.2.0.zip">this archive</a>.

Check out this repository into a folder within the Play Framework folder.

The directory structure should look like this:

    play-2.2.0/
        InventorySystem/


##Running
To compile and run the project, 'cd' into the play-2.2.0/InventorySystem folder and run:

`````bash
../play run

`````

Go to <a href="http://localhost:9000">localhost:9000</a> in your browser to see the application.
