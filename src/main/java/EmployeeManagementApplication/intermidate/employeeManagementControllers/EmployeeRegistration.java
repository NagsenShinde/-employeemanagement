package EmployeeManagementApplication.intermidate.employeeManagementControllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import EmployeeManagementApplication.intermidate.employeeManagementRepositories.EmployeeRegistrationRepo;
import EmployeeManagementApplication.intermidate.entityClasses.EmployeeRegistrationEntity;
import EmployeeManagementApplication.intermidate.servicelass.SendingOtpOnMail;
import jakarta.persistence.Column;
 
@RestController
public class EmployeeRegistration {
	
	@Autowired
	private EmployeeRegistrationRepo employeeRegistrationRepo;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private SendingOtpOnMail sendingOtpOnMail;
	
	
	@Autowired
	public EmployeeRegistration( SendingOtpOnMail sendingOtpOnMail)
	{
		this.sendingOtpOnMail = sendingOtpOnMail;
	}

	@GetMapping(value ="/viewAllEmployeeRegistrations")
	public List<EmployeeRegistrationEntity>viewAllEmployeeRegistrations()
	{
		return employeeRegistrationRepo.findAll();
		
	}
	
	@GetMapping(value ="/getEmplyeebyId/{emailId}")
	public EmployeeRegistrationEntity getEmplyeebyId(@PathVariable String emailId)
	{
		return employeeRegistrationRepo.findById(emailId).orElse(null);
	}
	
	@PostMapping(value ="addEmplyee")
	public String AddEmplyee(@RequestBody EmployeeRegistrationEntity employeeRegistrationEntity) 
	{
		employeeRegistrationEntity.setCreatedOn(java.time.LocalDateTime.now());
	    int min = 1000;
        int max = 9999;
        Random random = new Random();
        int otp=random.nextInt(max - min + 1) + min;
        System.out.println(otp);
        LocalDateTime currentTime = LocalDateTime.now();
        int expirationMinutes = Integer.parseInt(environment.getProperty("otp.expiration.minutes"));
        LocalDateTime expirationTime = currentTime.plusMinutes(expirationMinutes);
        System.out.println(expirationTime);
	    employeeRegistrationEntity.setOtpcode(otp);
		employeeRegistrationEntity.setOtpStartTime(java.time.LocalDateTime.now());
		employeeRegistrationEntity.setOtpExpireTime(expirationTime);
		employeeRegistrationEntity.setModifiedOn(java.time.LocalDateTime.now());
		employeeRegistrationEntity.setOtpStatus(true);
		System.out.println(employeeRegistrationEntity.toString());
		employeeRegistrationRepo.save(employeeRegistrationEntity);
		return "Emplyee sucessfully added";
	}
	
//	@PutMapping(value ="/updateEmplyeeDetails/{emailId}")
//	public String updateEmplyeeDetails(@RequestBody EmployeeRegistrationEntity employeeRegistrationEntity,@PathVariable String emailId)
//	{
//		System.out.println(employeeRegistrationEntity.toString());
//		EmployeeRegistrationEntity employeeRegistrationEntity1 =employeeRegistrationRepo.findById(emailId).orElse(null);
//		System.out.println(employeeRegistrationEntity1.toString());
//		    int min = 1000;
//	        int max = 9999;
//	        Random random = new Random();
//	        int otp=random.nextInt(max - min + 1) + min;
//	        System.out.println(otp);
//	        LocalDateTime currentTime = LocalDateTime.now();
//	        int expirationMinutes = Integer.parseInt(environment.getProperty("otp.expiration.minutes"));
//	        LocalDateTime expirationTime = currentTime.plusMinutes(expirationMinutes);
//	        System.out.println(expirationTime);
//	        
//	        if(employeeRegistrationEntity.getEmpEmailId()!=null)
//	        employeeRegistrationEntity1.setEmpEmailId(employeeRegistrationEntity.getEmpEmailId());
//	        
//	        if(employeeRegistrationEntity.getEmpPassword()!=null)
//	        employeeRegistrationEntity1.setEmpPassword(employeeRegistrationEntity.getEmpPassword());
//		    if(employeeRegistrationEntity.getOtpcode()!=0)
//	        employeeRegistrationEntity.setOtpcode(otp);
//		
//		   if(employeeRegistrationEntity.getOtpStartTime()!=null)
//			employeeRegistrationEntity1.setOtpStartTime(java.time.LocalDateTime.now());
//	       if(employeeRegistrationEntity.getOtpExpireTime()!=null)
//		    employeeRegistrationEntity1.setOtpExpireTime(expirationTime);
//	       if(employeeRegistrationEntity.getModifiedOn()!=null)
//		    employeeRegistrationEntity1 .setModifiedOn(java.time.LocalDateTime.now());
//		   if(!employeeRegistrationEntity.getOtpStatus()) 
//	       employeeRegistrationEntity1.setOtpStatus(true);
//		    employeeRegistrationRepo.save(employeeRegistrationEntity1);
//		    System.out.println(employeeRegistrationEntity.toString());
//		return "data sucessfully updated";
//		
//	}
	
	@GetMapping("/send-otp")
    public String sendOtp(@RequestParam String recipientEmail) {
		int min = 1000;
        int max = 9999;
        Random random = new Random();
        int otp1=random.nextInt(max - min + 1) + min;
        System.out.println(otp1);
        sendingOtpOnMail.sendOtpEmail(recipientEmail, otp1);
        System.out.println(sendingOtpOnMail);
        return "OTP sent successfully!";
    }
}
