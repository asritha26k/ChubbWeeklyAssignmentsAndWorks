import { Component } from '@angular/core';
import { UserService } from '../../services/user';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../models/User.model';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-user-edit',
  imports: [FormsModule],
    standalone:true,
  templateUrl: './user-edit.html',
  styleUrl: './user-edit.css',
})
export class UserEdit {

  user: User = {
    id: null,
    name: '',
    email: '',
  };
  id!: number; 
  constructor(
    private userService: UserService,
    private route: ActivatedRoute
  ) {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
  }

  addUser() {
    this.userService.updateUser(this.id,this.user).subscribe(() => {
      alert('User edited');
    });
  }
}
