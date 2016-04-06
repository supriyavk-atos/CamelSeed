package com.atos.backbase.model;

public class PersonData {

	private long empId;
	private String firstName;
	private String lastName;
	private String password;
	private String userName;
	private int age;
	private String phoneNumber;
	private String gender;
	private double salary;
	private String email;
	private String address;
	private String hobbies;

	
	/**
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the hobbies
	 */
	public String getHobbies() {
		return hobbies;
	}

	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonData [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password
				+ ", userName=" + userName + ", age=" + age + ", phoneNumber="
				+ phoneNumber + ", gender=" + gender + ", salary=" + salary
				+ ", email=" + email + ", address=" + address + ", hobbies="
				+ hobbies + "]";
	}

}