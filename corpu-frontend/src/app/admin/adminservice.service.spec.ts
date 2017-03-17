/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AdminserviceService } from './adminservice.service';

describe('AdminserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminserviceService]
    });
  });

  it('should ...', inject([AdminserviceService], (service: AdminserviceService) => {
    expect(service).toBeTruthy();
  }));
});
