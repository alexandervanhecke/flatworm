/**
 * Flatworm - A Java Flat File Importer Copyright (C) 2004 James M. Turner
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.blackbear.flatworm.ConfigurationReader;
import com.blackbear.flatworm.FileFormat;
import com.blackbear.flatworm.MatchedRecord;
import com.blackbear.flatworm.errors.FlatwormConfigurationValueException;
import com.blackbear.flatworm.errors.FlatwormConversionException;
import com.blackbear.flatworm.errors.FlatwormInputLineLengthException;
import com.blackbear.flatworm.errors.FlatwormInvalidRecordException;
import com.blackbear.flatworm.errors.FlatwormUnsetFieldValueException;

public class ComplexFlatwormExample
{
    public static void main(String[] args)
    {
        ConfigurationReader parser = new ConfigurationReader();
        try
        {
            FileFormat ff = parser.loadConfigurationFile(args[0]);
            InputStream in = new FileInputStream(args[1]);
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));

            MatchedRecord results;
            while ((results = ff.getNextRecord(bufIn)) != null)
            {
                if (results.getRecordName().equals("dvd"))
                {
                    System.out.println(results.getBean("dvd"));
                    System.out.println(results.getBean("film"));
                }
                if (results.getRecordName().equals("videotape"))
                {
                    System.out.println(results.getBean("video"));
                    System.out.println(results.getBean("film"));
                }
                if (results.getRecordName().equals("book"))
                {
                    System.out.println(results.getBean("book"));
                }
                System.out.println("");
            }

        } catch (FlatwormUnsetFieldValueException flatwormUnsetFieldValueError)
        {
            flatwormUnsetFieldValueError.printStackTrace(); // To change body of catch statement use Options | File
            // Templates.
        } catch (FlatwormConfigurationValueException flatwormConfigurationValueError)
        {
            flatwormConfigurationValueError.printStackTrace(); // To change body of catch statement use Options | File
            // Templates.
        } catch (FileNotFoundException e)
        {
            e.printStackTrace(); // To change body of catch statement use Options | File Templates.
        } catch (FlatwormInvalidRecordException e)
        {
            e.printStackTrace(); // To change body of catch statement use Options | File Templates.
        } catch (FlatwormInputLineLengthException e)
        {
            e.printStackTrace(); // To change body of catch statement use Options | File Templates.
        } catch (FlatwormConversionException e)
        {
            e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
        }
    }

}
