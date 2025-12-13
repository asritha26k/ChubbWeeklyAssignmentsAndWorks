import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/User.model'

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly apiUrl ='http://localhost:3000/users';
  constructor(private readonly http:HttpClient){}
  getUsers(){
    return this.http.get<User[]>(this.apiUrl);
  }
  getUserById(id:number){
    return this.http.get<User>(`${this.apiUrl}/${id}`);
  }
  addUser(user:User){
    return this.http.post<User>(this.apiUrl,user);
  }
  updateUser(id:number,user:User){
    return this.http.put<User>(`${this.apiUrl}/${id}`,user);
  }
  deleteUser(id:number){
    return this.http.delete<User>(`${this.apiUrl}/${id}`);
  }

}
